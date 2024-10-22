package com.lumen.dssh.orchestrator.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateKey;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.xml.XMLConstants;
import javax.xml.crypto.MarshalException;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureException;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.lumen.dssh.orchestrator.common.CommonStrings;


@Component
public class DigitalSignedXMLUtil {

	private final static Logger logger=LogManager.getLogger(DigitalSignedXMLUtil.class);

	public static final String SAML_FILE = "samlgen.xml";
	
	private DigitalSignedXMLUtil() {
	}

	public String getEncodedsignedSaml(String ccid, String mcafeeSAMLKeystoreFileName,String mcafeeSAMLKeystorePwd)
			throws SAXException, IOException, ParserConfigurationException, FileNotFoundException,
			NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyStoreException, CertificateException,
			UnrecoverableEntryException, UnrecoverableKeyException, MarshalException, XMLSignatureException,
			TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		// Instantiate the document to be signed.
		// DocumentBuilderFactory class defines a factory API that enables
		// applications to obtain a parser that produces DOM object trees from
		// XML documents.
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
		dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
		dbf.setAttribute(XMLConstants.FEATURE_SECURE_PROCESSING, true);

		//As per suggestions by OWASP
		// https://cheatsheetseries.owasp.org/cheatsheets/XML_External_Entity_Prevention_Cheat_Sheet.html
		dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
		dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
		dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
		// Disable external DTDs as well
		dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		// and these as well, per Timothy Morgan's 2014 paper: "XML Schema, DTD, and Entity Attacks"
		dbf.setXIncludeAware(false);
		dbf.setExpandEntityReferences(false);

		// The
		// Javax.xml.parsers.DocumentBuilderFactory.setNamespaceAware(boolean
		// awareness) method specifies that the parsers created by this factory
		// will provide support for XML namespaces. By default the value of this
		// is set to false.
		dbf.setNamespaceAware(true);

		Document doc = updateSamlXmlWithProperties(dbf, ccid);

		logger.info("Starts a few of the key steps in generating an XML signature");

		// Each instance of XMLSignatureFactory supports a specific XML
		// mechanism type. To create an XMLSignatureFactory, call one of the
		//  getInstance methods, passing in the XML mechanism type
		// desired,Here The objects that this factory produces will be based on
		// DOM
		// Create a Reference to the enveloped document (in this case,
		// you are signing the whole document, so a URI of "" signifies
		// that, and also specify the SHA1 digest algorithm and
		// the ENVELOPED Transform.3rd argument is list of transformations here
		// use Enveloped. we have xpath also
		// Enveloped means produce signature with in document in root element.
		// A Reference element is out come of defined Recommendation(right side)
		// for XML-Signature Syntax and Processing.

		// Create the SignedInfo.
		// The following canonicalization algorithms are used in : Canonical XML
		// (or Inclusive XML Canonicalization)(XMLC14N) and Exclusive XML
		// Canonicalization(EXCC14N). The first is used for XML where the
		// context doesn't change while the second was designed for
		// canonicalization where the context might change.

		// Inclusive Canonicalization copies all the declarations, even if they
		// are defined outside of the scope of the signature. In this way all
		// the declarations you might use will be unambiguously specified. A
		// problem appears when the signed XML is moved into another XML
		// document which has other declarations because the Inclusive
		// Canonicalization will copy then and the signature will be invalid.



		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
		  DigestMethod digestMethod =
		      fac.newDigestMethod("http://www.w3.org/2000/09/xmldsig#sha1", null);
		 C14NMethodParameterSpec spec = null;
		  CanonicalizationMethod cm = fac.newCanonicalizationMethod(
				  CanonicalizationMethod.INCLUSIVE,spec);
		  SignatureMethod sm = fac.newSignatureMethod(
		      "http://www.w3.org/2000/09/xmldsig#rsa-sha1",null);
		  ArrayList<Transform> transformList = new ArrayList<>();
		  TransformParameterSpec transformSpec = null;
		  Transform envTransform = fac.newTransform("http://www.w3.org/2001/10/xml-exc-c14n#",transformSpec);
		  Transform exc14nTransform = fac.newTransform(
		      "http://www.w3.org/2000/09/xmldsig#enveloped-signature",transformSpec);
		  transformList.add(exc14nTransform);
		 transformList.add(envTransform);
		 Reference ref = fac.newReference("",digestMethod,transformList,null,null);
		 ArrayList<Reference> refList = new ArrayList<>();
		 refList.add(ref);
		 SignedInfo signedInfo =fac.newSignedInfo(cm,sm,refList);

		logger.info("Ends a few of the key steps in generating an XML signature");

		KeyStore.PrivateKeyEntry keyEntry = populateCertValues(mcafeeSAMLKeystoreFileName,mcafeeSAMLKeystorePwd);

		// getting X509Certificate from keyEntry
		X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

		KeyInfo ki = getKeyInfoFromX509Data(fac, cert);

		// Create a DOMSignContext and specify the RSA PrivateKey and
		// location of the resulting XMLSignature's parent element.
		DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getDocumentElement());

		// to add name space ds for signature and it's sub elements
		dsc.setDefaultNamespacePrefix("ds");

		// Create the XMLSignature, but don't sign it yet.
		XMLSignature signature = fac.newXMLSignature(signedInfo, ki);

		// Marshal, generate, and sign the enveloped signature.
		signature.sign(dsc);

		// Output the resulting String.
		TransformerFactory tf = TransformerFactory.newInstance();
		// Sonar suggestions: to be compliant, prohibit the use of all protocols by external entities:
		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");//Compliant
		tf.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");//Compliant
		Transformer trans = tf.newTransformer();
		StringWriter writer = new StringWriter();
		trans.transform(new DOMSource(doc), new StreamResult(writer));
		String samlSignedXmlString = writer.toString();
		logger.info("Saml formatted xml with signature is  " + samlSignedXmlString);

		// Encoding with Base 64
		Base64.Encoder encoder = Base64.getEncoder();
		String base64EncdSignSamlString = encoder.encodeToString(samlSignedXmlString.getBytes());
		logger.info("encoded string " + base64EncdSignSamlString);
		logger.info("completed");
		return base64EncdSignSamlString;
	}

	private static KeyInfo getKeyInfoFromX509Data(XMLSignatureFactory fac, X509Certificate cert) {
		// Create the KeyInfo containing the X509Data.
		KeyInfoFactory kif = fac.getKeyInfoFactory();
		List<X509Certificate> x509Content = new ArrayList<>();
		x509Content.add(cert);
		X509Data xd = kif.newX509Data(x509Content);
		KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));
		return ki;
	}

	private static KeyStore.PrivateKeyEntry populateCertValues(String mcafeeSAMLKeystoreFileName, String mcafeeSAMLKeystorePwd)
			throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException,
			FileNotFoundException, UnrecoverableEntryException, UnrecoverableKeyException {

		//getting key store file path
		 String jks_Path = CommonStrings.TEMPLATES_PATH;
		String jks_file = mcafeeSAMLKeystoreFileName;
		logger.info("starts populateCertValues");
		logger.info("Starts Load the KeyStore and get the signing key and certificate");
		// part 2: Load the KeyStore and get the signing key and certificate.
		// create a Java KeyStore instance by calling its getInstance() method.
		KeyStore ks = KeyStore.getInstance("JKS");

		// Loading the KeyStore data from a file or other storage is done by
		// calling the KeyStore load() method.
		// The load() takes tw parameters:An InputStream from which to load the
		// KeyStore data.A char[] (char array) containing the KeyStore password.
		// mynameisown is jks passphrase/password.
		// my-own1.jks is jks file name.

		String jks_pd = mcafeeSAMLKeystorePwd;
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		try(InputStream in=
				resourceLoader.getResource(CommonStrings.CLASSPATH + mcafeeSAMLKeystoreFileName + ".jks").getInputStream()
		){
			logger.info("Inputstream Resource Path="+CommonStrings.CLASSPATH + mcafeeSAMLKeystoreFileName + ".jks");
			ks.load(in, jks_pd.toCharArray());
		}
		catch (IOException e){
			logger.error("DigitalSignedXMLUtil-> populateCertValues(). Error in reading JKS file \n{}",e.getMessage());
			throw e;
		}
		
		// we need to use alias name which we gave name while creating jks file
		String jks_alias = jks_file;
		
		

		// private key and keyEntry will be returned with jks file's alias and
		// jks file's password.
		// mya-e2e is jks file alias name and mynameise2e is jks passphrase.

		// A KeyStore's PrivateKeyEntry holds a PrivateKey and corresponding
		// certificate chain.

		KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(jks_alias,
				new KeyStore.PasswordProtection(jks_pd.toCharArray()));
		logger.info("keyEntry is " + keyEntry);

		RSAPrivateKey privateKey = (RSAPrivateKey) ks.getKey(jks_alias, jks_pd.toCharArray());
		logger.info("private Key is " + privateKey);
		logger.info("encoded string "+privateKey.getEncoded());
		logger.info("format is "+privateKey.getFormat());
		logger.info("private key also can get with keyentry " + keyEntry.getPrivateKey());

		// public key is generated with jks file's alias only. public key can
		// give to third party which is McAfee.
		PublicKey publicKey = ks.getCertificate(jks_alias).getPublicKey();
		logger.info("public key algorith "+publicKey.getAlgorithm());
		logger.info("public key encoded "+publicKey.getEncoded());
		logger.info("public key format "+publicKey.getFormat());
		logger.info("public key is " + publicKey);
		logger.info("Ends populateCertValues");
		return keyEntry;
	}

	private static Document updateSamlXmlWithProperties(DocumentBuilderFactory dbf, String ccidVal)
			throws SAXException, IOException, ParserConfigurationException, FileNotFoundException {
		logger.info("start updating  properties and ccid is" + ccidVal);
		logger.info("Parsing Starts");

		Document doc = null;
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		try(InputStream in=
					resourceLoader.getResource(CommonStrings.CLASSPATH + SAML_FILE).getInputStream()
		){
			dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ""); // Compliant
			dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ""); // compliant
			DocumentBuilder builder = dbf.newDocumentBuilder();
			doc = builder.parse(in);
		}
		catch (IOException e){
			logger.error("DigitalSignedXMLUtil-> updateSamlXmlWithProperties(). Error in reading samlgen.xml file \n{}",e.getMessage());
			throw e;
		}
		
		String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Date issueAt = Calendar.getInstance().getTime();

		// for previous day, as McAfee server wants one before  date as their server places USA
		Calendar precal = Calendar.getInstance();
		precal.add(Calendar.DATE, -1);
		Date yesterday = precal.getTime();
		
		// expires at 30 minutes later (for testing purposes, it's 24 hours for now)
		long later = issueAt.getTime() + (60000 * 60 * 24);
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(later);
		Date expiresAt = cal.getTime();
		String issueAtString = sdf.format(issueAt);
		String issueAtYdayString = sdf.format(yesterday);
		String expiresAtString = sdf.format(expiresAt);
		logger.info("certificate issue at " + issueAtString);
		logger.info("certificate expire at " + expiresAtString);
		logger.info("certific issue one day before " + issueAtYdayString);
		// UUID value hepls ud to add unique ID, Universally Unique IDentifier (UUID)
		 UUID uniqueKey = UUID.randomUUID();
		 logger.info("UUID Value " + uniqueKey.toString());
		doc.getElementsByTagName("saml:Conditions").item(0).getAttributes().getNamedItem("NotBefore").setNodeValue(issueAtYdayString);
		doc.getElementsByTagName("saml:Conditions").item(0).getAttributes().getNamedItem("NotOnOrAfter").setNodeValue(expiresAtString);
		doc.getElementsByTagName("saml:SubjectConfirmationData").item(0).getAttributes().getNamedItem("NotOnOrAfter").setNodeValue(expiresAtString);
		doc.getElementsByTagName("saml:AuthnStatement").item(0).getAttributes().getNamedItem("AuthnInstant").setNodeValue(issueAtYdayString);
		doc.getElementsByTagName("saml:AuthnStatement").item(0).getAttributes().getNamedItem("SessionNotOnOrAfter").setNodeValue(expiresAtString);
		doc.getElementsByTagName("saml:Assertion").item(0).getAttributes().getNamedItem("IssueInstant").setNodeValue(issueAtYdayString);
		doc.getElementsByTagName("saml:Assertion").item(0).getAttributes().getNamedItem("ID").setNodeValue(uniqueKey.toString());
		doc.getElementsByTagName("saml:AttributeValue").item(2).setTextContent(ccidVal);
		logger.info("end updating properties and ccid is" + ccidVal);
		return doc;
	}
	

}
