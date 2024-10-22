import { createStore } from 'vuex'
import axios from 'axios'
import CryptoJS from 'crypto-js'

const accepted = 'accepted'
const declined = 'declined'
const eligible = 'ELIGIBLE'
const ineligible = 'INELIGIBLE'
const modemOfferName = 'ModemReplacement'
const serviceCreditOfferName = 'OutOfServiceCredit'
export default createStore({
    state: {
        isAuth: false,
        /* User */
        userEmail: null,
        posts: [],
        currentManagingPId: null,
        profileID: '', // This will contain the customer login user id
        profiledata: [],
        orderHistories: [],
        notificationData: {},
        homeEarlyInitResponseHeaders: '',
        isBrightspeedCustomer: false,
        hasalternateTelephoneNumber: false,
        qrlCode: null,
        connectedVoiceAdd: false,
        changeModem: false,
        /* FormScreen - fullscreen form layout (e.g. login page) */
        isFormScreen: false,
        /* HSI */
        accountNumber: '',
        isBlueMarble: false,
        hasEBBPDiscount: false,
        isEligibleForCancel: false,
        hasConnectedVoice: false,
        hasACPDiscount: false,
        hasLifelinediscount: false,
        voicemailCTA: false,
        simplyUnlimitedPhone: false,
        isHsiCallSucc: false, // this indicates if the getServices call was successful or not
        isHSICallDone: false,
        isHsiOwned: false,
        isSmartNidModem: false,
        isPhoneOwned: false,
        isAddOns: {},
        isOutage: false,
        outageHangover: false,
        outageRebootModem: false,
        outageEstRepairTime: false,
        outageId: '',
        downloadSpeed: null,
        maxSpeedHsiTechTypeAvail: null,
        hsiAvail: false,
        broadbandExhaust: false,
        ownedSpeedTechType: null,
        maxSpeedHSIAvailable: null,
        accountSvcAndOffrs: [],
        accountType: '',
        currUrl: '',
        companyOwnerId: null,
        nextPaymentAmount: '',
        offerHsiInd: 'none', // this will contain either none, link, or chat depending upon the ability to offer a Higher speed HSI. The intent is to simplify the display logic of the child
        upgradeEligibleHSI: 'Unknown',
        isPrepaidInactive: null,
        accountTypeCookie: 'Unknown',
        statecode: 'Unknown',
        zipcode: 'Unknown',
        autoPay: 'Unknown',
        paperlessBilling: 'Unknown',
        hasPaperlessBilling: false,
        billingEmailAddress: '',
        emailAddressForLogging: '',
        customerType: 'Unknown',
        billingEntity: 'Unknown',
        territory: null,
        ableToShopOnline: 'Unknown',
        ownsDTV: 'Unknown',
        isPrepaidSuspended: null,
        modemInfo: {},
        networkResponse: [],
        // manufacturer: '',
        // modelName: '',
        // macAddress: '',
        // connectionStatus: '',
        billDetail: null,
        billDetailPdf: null,
        billsList: null,
        hasCPNIProducts: null,
        enrollmentAccNumber: null,
        enrollmentSuccessEmail: null,
        billingCycleList: null,
        schdPymtList: [],
        pndPymtList: null,
        postdPymtList: null,
        postpaidBillDates: null,
        /* Aside */
        isAsideMobileExpanded: false,
        isPaymentLate: false,
        shellProfileData: null,
        accountNumberAdd: null,
        timedWkResp: null,
        showSuspendedAccount: true,
        showCancelOrderAlert: false,
        paperBillChargeApplies: false,
        canShowSpinner: false,
        disableCancelOrderButton: false,
        paymentID: '',
        retryPaymentSuccess: false,
        showPrepaidActiveAlert: true,
        // pppCardStatus = '0' signifies card is not expired and not expiring soon
        // pppCardStatus = '1' signifies card is expired
        // pppCardStatus = '2' signifies card is not expired but expiring within 60 days
        pppCardStatus: 0,
        isSoftWG: false,
        wgStatus: false,
        isHardWG: false,
        wkLocation: null,
        workNm: null,
        workTyp: null,
        wrkEffort: null,
        isLatPaymentDateInPeriod: false,
        isLatePaymentDateInPeriod: false,
        loginID: '',
        isWGPaymentSuccess: '',
        isNetworkConnected: '',
        isPostChangesWithTokenSuccess: false,
        isGetTokenSuccess: false,
        isFrgtPwdStep2RespSuccessful: false,
        isRetrieveAuthCodeSuccessful: false,
        isFrgtPwdStep1RespSuccessful: false,
        isRetrvEmailorMailResSuccessful: false,
        isGetEmailIDRespSuccessful: false,
        isRetrieveAccountNumberSuccessful: false,
        isPostUserProfileRespSuccessful: false,
        isgetServiceDetailsSuccess: false,
        isWGStatusCallSuccess: '',
        isConnectedDevicesCallSuccess: false,
        connectedDevicesListResponse: null,
        /* rateChange related */
        isRateChangeCallSuccessful: false,
        rateChangeResponse: null,
        rateChangeNotification: false,
        isPATokenCallSuccess: false,
        canVacationSuspend: false,
        isVacationSuspended: false,
        canVacationRestored: false,
        isVacationallySuspended: '',
        isBYOM: false,
        isThirdPartyModem: false,
        nbaModemReplacement: null,
        nbaCallDone: false,
        isWheresMyTechKillSwitch: false, // indicates if there was a switch found and set to true to skip/bypass the new wheres my tech related functionality
        getOrderInteractionInfoCallSuccess: null, // indicates if the call to interactionInfo was successful or not. Does not give any indication regarding what data may have been returned
        getOrderInteractionInfo: [], // will hold the list of interactions from the InterActionInfo call is any messages were returned
        getTechTrackerFound: null, // indicates if the InteractionInfo had indicated that it had found a techTracker number or not - DO NOT USE this to indicate if the tech tracker pager had failed or not - use tech_Tracker_failed instead
        foundSmsMsg: null, // indicates if there were any SMS messages returned from last interactionInfo call
        clickTechTrackerCallSuccess: null, // indicates whether the call to get the tech tracker was successful, it does not indicate if the tech tracker was found
        tech_Tracker_failed: null, // indicates whether the tech tracker was found true means the techTracker was not found when attempting to show tech tracker location
        accptRejectCallSuccessful: null,
        showSMScomm: false,
        showTechTracker: false,
        nbaOutOfServiceCreditsOfferStatus: ineligible,
        nbaOutOfServiceCreditsOfferValue: null,
        isNetWorkServiceCallDoneOnce: false,
        isDisplayErrorCreditModal: false,
        appKey: null,
        isAssiaEnabled: false,
        historicalSpeeds: {},
        elementFound: false,
        contactElementFound: false,
        requestId: null,
        currentSpeed: {},
        isDataFlowChecked: false
    },
    getters: {
        isAssiaEnabled: state => state.isAssiaEnabled,
        historicalSpeeds: state => state.historicalSpeeds,
        isAuth: state => state.isAuth,
        posts: state => state.posts,
        profileId: state => state.profileID,
        profiledata: state => state.profiledata,
        orderHistories: state => state.orderHistories,
        notificationData: state => state.notificationData,
        homeEarlyInitResponseHeaders: state => state.homeEarlyInitResponseHeaders,
        isBrightspeedCustomer: state => state.isBrightspeedCustomer,
        showSMScomm: state => state.showSMScomm,
        showApptmsg: state => state.showApptmsg,
        showTechTracker: state => state.showTechTracker,
        nbaOutOfServiceCreditsOfferStatus: state => state.nbaOutOfServiceCreditsOfferStatus,
        nbaOutOfServiceCreditsOfferValue: state => state.nbaOutOfServiceCreditsOfferValue,
        accountNumber: state => state.accountNumber,
        isBlueMarble: state => state.isBlueMarble,
        billingEntity: state => state.billingEntity,
        territory: state => state.territory,
        ableToShopOnline: state => state.ableToShopOnline,
        ownsDTV: state => state.ownsDTV,
        hasEBBPDiscount: state => state.hasEBBPDiscount,
        isEligibleForCancel: state => state.isEligibleForCancel,
        isPONR: state => state.isPONR,
        hasConnectedVoice: state => state.hasConnectedVoice,
        hasACPDiscount: state => state.hasACPDiscount,
        hasLifelinediscount: state => state.hasLifelinediscount,
        voicemailCTA: state => state.voicemailCTA,
        simplyUnlimitedPhone: state => state.simplyUnlimitedPhone,
        isHsiCallSucc: state => state.isHsiCallSucc,
        isHSICallDone: state => state.isHSICallDone,
        isHsiOwned: state => state.isHsiOwned,
        isSmartNidModem: state => state.isSmartNidModem,
        isPhoneOwned: state => state.isPhoneOwned,
        isAddOns: state => state.isAddOns,
        isOutage: state => state.isOutage,
        outageHangover: state => state.outageHangover,
        outageRebootModem: state => state.outageRebootModem,
        outageEstRepairTime: state => state.outageEstRepairTime,
        outageId: state => state.outageId,
        downloadSpeed: state => state.downloadSpeed,
        maxSpeedHsiTechTypeAvail: state => state.maxSpeedHsiTechTypeAvail,
        hsiAvail: state => state.hsiAvail,
        wkLocation: state => state.wkLocation,
        workNm: state => state.workNm,
        workTyp: state => state.workTyp,
        wrkEffort: state => state.wrkEffort,
        offerHsiInd: state => state.offerHsiInd,
        upgradeEligibleHSI: state => state.upgradeEligibleHSI,
        broadbandExhaust: state => state.broadbandExhaust,
        maxSpeedHSIAvailable: state => state.maxSpeedHSIAvailable,
        accountSvcAndOffrs: state => state.accountSvcAndOffrs,
        hasalternateTelephoneNumber: state => state.hasalternateTelephoneNumber,
        connectedVoiceAdd: state => state.connectedVoiceAdd,
        changeModem: state => state.changeModem,
        accountType: state => state.accountType,
        currUrl: state => state.currUrl, // this will hold the current url
        nextPaymentAmount: state => state.nextPaymentAmount,
        isPrepaidInactive: state => state.isPrepaidInactive,
        accountTypeCookie: state => state.accountTypeCookie,
        statecode: state => state.statecode,
        zipcode: state => state.zipcode,
        autoPay: state => state.autoPay,
        paperlessBilling: state => state.paperlessBilling,
        hasPaperlessBilling: state => state.hasPaperlessBilling,
        billingEmailAddress: state => state.billingEmailAddress,
        emailAddressForLogging: state => state.emailAddressForLogging,
        customerType: state => state.customerType,
        isPrepaidSuspended: state => state.isPrepaidSuspended,
        modemInfo: state => state.modemInfo,
        networkResponse: state => state.networkResponse,
        currentManagingPId: state => state.currentManagingPId,
        // manufacturer: state => state.manufacturer,
        // modelName: state => state.modelName,
        // macAddress: state => state.macAddress,
        // connectionStatus: state => state.connectionStatus,
        billDetail: state => state.billDetail,
        billDetailPdf: state => state.billDetailPdf,
        billsList: state => state.billsList,
        hasCPNIProducts: state => state.hasCPNIProducts,
        enrollmentAccNumber: state => state.enrollmentAccNumber,
        enrollmentSuccessEmail: state => state.enrollmentSuccessEmail,
        billingCycleList: state => state.billingCycleList,
        schdPymtList: state => state.schdPymtList,
        pndPymtList: state => state.pndPymtList,
        postdPymtList: state => state.postdPymtList,
        postpaidBillDates: state => state.postpaidBillDates,
        isPaymentLate: state => state.isPaymentLate,
        emailResponse: state => state.emailResponse,
        acodProfile: state => state.acodProfile,
        shellProfileData: state => state.shellProfileData,
        accountNumberAdd: state => state.accountNumberAdd,
        retrieveAccountNumberResponse: state => state.retrieveAccountNumberResponse,
        frgtPasswordStep1Response: state => state.frgtPasswordStep1Response,
        frgtPasswordStep2Response: state => state.frgtPasswordStep2Response,
        getTokenResponse: state => state.getTokenResponse,
        getTimedWkResp: state => state.getTimedWkResp,
        retrieveAuthCodeResponse: state => state.retrieveAuthCodeResponse,
        retrieveEmailorMailResponse: state => state.retrieveEmailorMailResponse,
        paTokenResponse: state => state.paTokenResponse,
        isPATokenCallSuccess: state => state.isPATokenCallSuccess,
        getChagesPasswordWithToken: state => state.getChagesPasswordWithToken,
        showSuspendedAccountMessage: state => state.showSuspendedAccount,
        showCancelOrderAlertMessage: state => state.showCancelOrderAlert,
        setpaperBillChargeApplies: state => state.paperBillChargeApplies,
        companyOwnerId: state => state.companyOwnerId,
        canShowSpinner: state => state.canShowSpinner,
        disableCancelOrderButton: state => state.disableCancelOrderButton,
        paymentID: state => state.paymentID,
        retryPaymentSuccess: state => state.retryPaymentSuccess,
        getShowPrepaidActiveAlert: state => state.showPrepaidActiveAlert,
        getPppCardStatus: state => state.pppCardStatus,
        isSoftWG: state => state.isSoftWG,
        wgStatus: state => state.wgStatus,
        isWGStatusCallSuccess: state => state.isWGStatusCallSuccess,
        isConnectedDevicesCallSuccess: state => state.isConnectedDevicesCallSuccess,
        connectedDevicesListResponse: state => state.connectedDevicesListResponse,
        isHardWG: state => state.isHardWG,
        isLatPaymentDateInPeriod: state => state.isLatPaymentDateInPeriod,
        isLatePaymentDateInPeriod: state => state.isLatePaymentDateInPeriod,
        loginID: state => state.loginID,
        isWGPaymentSuccess: state => state.isWGPaymentSuccess,
        isNetworkConnected: state => state.isNetworkConnected,
        isPostChangesWithTokenSuccess: state => state.isPostChangesWithTokenSuccess,
        isGetTokenSuccess: state => state.isGetTokenSuccess,
        isFrgtPwdStep2RespSuccessful: state => state.isFrgtPwdStep2RespSuccessful,
        isRetrieveAuthCodeSuccessful: state => state.isRetrieveAuthCodeSuccessful,
        isFrgtPwdStep1RespSuccessful: state => state.isFrgtPwdStep1RespSuccessful,
        isRetrvEmailorMailResSuccessful: state => state.isRetrvEmailorMailResSuccessful,
        isGetEmailIDRespSuccessful: state => state.isGetEmailIDRespSuccessful,
        isRetrieveAccountNumberSuccessful: state => state.isRetrieveAccountNumberSuccessful,
        isPostUserProfileRespSuccessful: state => state.isPostUserProfileRespSuccessful,
        isgetServiceDetailsSuccess: state => state.isgetServiceDetailsSuccess,
        qrlCode: state => state.qrlCode,
        isRateChangeCallSuccessful: state => state.isRateChangeCallSuccessful,
        rateChangeResponse: state => state.rateChangeResponse,
        rateChangeNotification: state => state.rateChangeNotification,
        canVacationSuspend: state => state.canVacationSuspend,
        isVacationSuspended: state => state.isVacationSuspended,
        canVacationRestored: state => state.canVacationRestored,
        isVacationallySuspended: state => state.isVacationallySuspended,
        isBYOM: state => state.isBYOM,
        isThirdPartyModem: state => state.isThirdPartyModem,
        nbaModemReplacement: state => state.nbaModemReplacement,
        nbaCallDone: state => state.nbaCallDone,
        accptRejectCallSuccessful: state => state.accptRejectCallSuccessful,
        nbaCaptureResponse: state => state.nbaCaptureResponse,
        appKey: state => state.appKey,
        isWheresMyTechKillSwitch: state => state.isWheresMyTechKillSwitch,
        getOrderInteractionInfoCallSuccess: state => state.getOrderInteractionInfoCallSuccess,
        clickTechTrackerCallSuccess: state => state.clickTechTrackerCallSuccess,
        tech_Tracker_failed: state => state.tech_Tracker_failed,
        getTechTrackerFound: state => state.getTechTrackerFound,
        foundSmsMsg: state => state.foundSmsMsg,
        getOrderInteractionInfo: state => state.getOrderInteractionInfo,
        isNetWorkServiceCallDoneOnce: state => state.isNetWorkServiceCallDoneOnce,
        isDisplayErrorCreditModal: state => state.isDisplayErrorCreditModal,
        elementFound: state => state.elementFound,
        contactElementFound: state => state.contactElementFound,
        requestId: state => state.requestId,
        currentSpeed: state => state.currentSpeed,
        // isWGServiceCallDone: state => state.isWGServiceCallDone
        isDataFlowChecked: state => state.isDataFlowChecked
    },
    mutations: {
        setElementFound (state, elementFound) {
            state.elementFound = elementFound
        },
        setContactElementFound (state, contactElementFound) {
            state.contactElementFound = contactElementFound
        },
        /* A fit-them-all commit */
        basic (state, payload) {
            state[payload.key] = payload.value
        },

        /* User */
        user (state, payload) {
            if (payload.name) {
                state.profileID = payload.name
            }
            if (payload.email) {
                state.userEmail = payload.email
            }
        },
        setcheckAuth (state, isAuth) {
            state.isAuth = isAuth
        },
        /* HSI */
        setAccountNumber (state, inAccountNumber) {
            state.accountNumber = inAccountNumber
        },
        setIsBlueMarble (state, inIsBlueMarble) {
            state.isBlueMarble = inIsBlueMarble
        },
        setHasEBBPDiscount (state, inHasEBBPDiscount) {
            state.hasEBBPDiscount = inHasEBBPDiscount
        },
        setIsEligibleForCancel (state, inEligibleForCancel) {
            state.isEligibleForCancel = inEligibleForCancel
        },
        setisPONR (state, isPONR) {
            state.isPONR = isPONR
        },
        setHasConnectedVoice (state, inHasConnectedVoice) {
            state.hasConnectedVoice = inHasConnectedVoice
        },
        setHasACPDiscount (state, inHasACPDiscount) {
            state.hasACPDiscount = inHasACPDiscount
        },
        sethasLifelinediscount (state, hasLifelinediscount) {
            state.hasLifelinediscount = hasLifelinediscount
        },
        setVoicemailCTA (state, isVoicemailCTA) {
            state.voicemailCTA = isVoicemailCTA
        },
        setSimplyUnlimitedPhone (state, isSimplyUnlimitedPhone) {
            state.simplyUnlimitedPhone = isSimplyUnlimitedPhone
        },
        setIsHsiCallSucc (state, inHsiCallFlag) {
            state.isHsiCallSucc = inHsiCallFlag
        },
        setIsHSICallDone (state, isHSICallDone) {
            state.isHSICallDone = isHSICallDone
        },
        setIsHsiOwned (state, isHsiOwnedFlag) {
            state.isHsiOwned = isHsiOwnedFlag
        },
        setIsSmartNidModem (state, isSmartNidModem) {
            state.isSmartNidModem = isSmartNidModem
        },
        setIsPhoneOwned (state, isPhoneOwnedFlag) {
            state.isPhoneOwned = isPhoneOwnedFlag
        },
        setAddOns (state, issAddOnsFlag) {
            state.isAddOns = issAddOnsFlag
        },
        setmodemInfo (state, modemInfoDetails) {
            state.modemInfo = modemInfoDetails
        },
        setnetworkResponse (state, networkResponse) {
            state.networkResponse = networkResponse
        },
        // setIsgetServiceDetailsSuccess (state, isgetServiceDetailsSuccess) {
        //   state.isgetServiceDetailsSuccess = isgetServiceDetailsSuccess
        // },
        setisOutage (state, isOutage) {
            state.isOutage = isOutage
        },
        setOutageHangover (state, outageHangover) {
            state.outageHangover = outageHangover
        },
        setOutageRebootModem (state, outageRebootModem) {
            state.outageRebootModem = outageRebootModem
        },
        setOutageEstRepairTime (state, outageEstRepairTime) {
            state.outageEstRepairTime = outageEstRepairTime
        },
        setOutageId (state, outageId) {
            state.outageId = outageId
        },
        setDownloadSpeed (state, inDownloadSpeed) {
            state.downloadSpeed = inDownloadSpeed
        },
        setMaxSpeedHsiTechTypeAvail (state, inMxSpdHsiTchTypAval) {
            state.maxSpeedHsiTechTypeAvail = inMxSpdHsiTchTypAval
        },
        setHsiAvail (state, isHsiAvailable) {
            state.hsiAvail = isHsiAvailable
        },
        setOfferHsiInd (state, inOfferHsiInd) {
            state.offerHsiInd = inOfferHsiInd
        },
        setupgradeEligibleHSI (state, upgradeEligibleHSI) {
            state.upgradeEligibleHSI = upgradeEligibleHSI
        },
        setBroadbandExhaust (state, isBroadbandExhaust) {
            state.broadbandExhaust = isBroadbandExhaust
        },
        setOwnedSpeedTechType (state, inOwnedSpeedTechType) {
            state.ownedSpeedTechType = inOwnedSpeedTechType
        },
        setMaxSpeedHSIAvailable (state, inMaxSpeedHSIAvailable) {
            state.maxSpeedHSIAvailable = inMaxSpeedHSIAvailable
        },
        setHasAlternateTelephoneNumber (state, hasalternateTelephoneNumber) {
            state.hasalternateTelephoneNumber = hasalternateTelephoneNumber
        },
        setAccountSvcAndOffrs (state, inAccountSvcAndOffrs) {
            state.accountSvcAndOffrs = inAccountSvcAndOffrs
        },
        setConnectedVoiceAdd (state, connectedVoiceAdd) {
            state.connectedVoiceAdd = connectedVoiceAdd
        },
        setChangeModem (state, changeModem) {
            state.changeModem = changeModem
        },
        setProfileId (state, payload) {
            state.profileID = payload
        },
        SET_ITEMS (state, posts) {
            state.posts = posts
        },
        setCurrentManagingPId (state, currentManagingPId) {
            state.currentManagingPId = currentManagingPId
        },
        setNotifications (state, notificationData) {
            state.notificationData = notificationData
        },
        setBillDetail (state, billDetail) {
            state.billDetail = billDetail
        },
        setBillDetailPdf (state, billDetailPdf) {
            state.billDetailPdf = billDetailPdf
        },
        setBillsList (state, billsList) {
            state.billsList = billsList
        },
        setCPNIProducts (state, hasCPNIProducts) {
            state.hasCPNIProducts = hasCPNIProducts
        },
        setEnrollmentAccNumber (state, enrollmentAccNumber) {
            state.enrollmentAccNumber = enrollmentAccNumber
        },
        setEnrollmentSuccessEmail (state, enrollmentSuccessEmail) {
            state.enrollmentSuccessEmail = enrollmentSuccessEmail
        },
        setBillingCycleList (state, billingCycleList) {
            state.billingCycleList = billingCycleList
        },
        setSchedList (state, schdPymtList) {
            state.schdPymtList = schdPymtList
        },
        setPendList (state, pndPymtList) {
            state.pndPymtList = pndPymtList
        },
        setPostdList (state, postdPymtList) {
            state.postdPymtList = postdPymtList
        },
        setPostpaidBillDates (state, postpaidBillDates) {
            state.postpaidBillDates = postpaidBillDates
        },
        setprofileDataHome (state, profiledata) {
            state.profiledata = profiledata
        },
        setorderhistories (state, orderHistories) {
            state.orderHistories = orderHistories
        },
        sethomeEarlyInitResponseHeaders (state, homeEarlyInitResponseHeaders) {
            state.homeEarlyInitResponseHeaders = homeEarlyInitResponseHeaders
        },
        setisBrightspeedCustomer (state, isBrightspeedCustomer) {
            state.isBrightspeedCustomer = isBrightspeedCustomer
        },
        setShow_SMS_comm (state, showSMScomm) {
            state.showSMScomm = showSMScomm
        },
        setshowApptmsg (state, showApptmsg) {
            state.showApptmsg = showApptmsg
        },
        setShow_tech_tracker (state, showTechTracker) {
            state.showTechTracker = showTechTracker
        },
        setNbaOutOfServiceCreditsOfferStatus (state, nbaOutOfServiceCreditsOfferStatus) {
            state.nbaOutOfServiceCreditsOfferStatus = nbaOutOfServiceCreditsOfferStatus
        },
        setNbaOutOfServiceCreditsOfferValue (state, nbaOutOfServiceCreditsOfferValue) {
            state.nbaOutOfServiceCreditsOfferValue = nbaOutOfServiceCreditsOfferValue
        },
        setbillingEntity (state, billingEntity) {
            state.billingEntity = billingEntity
        },
        setterritory (state, territory) {
            state.territory = territory
        },
        setableToShopOnline (state, ableToShopOnline) {
            state.ableToShopOnline = ableToShopOnline
        },
        setownsDTV (state, ownsDTV) {
            state.ownsDTV = ownsDTV
        },
        setAccountType (state, accountType) {
            state.accountType = accountType
        },
        setCurrUrl (state, currUrl) {
            state.currUrl = currUrl
        },
        setnextPaymentAmount (state, nextPaymentAmount) {
            state.nextPaymentAmount = nextPaymentAmount
        },
        setIsPrepaidInactive (state, isPrepaidInactive) {
            state.isPrepaidInactive = isPrepaidInactive
        },
        setaccountTypeCookie (state, accountTypeCookie) {
            state.accountTypeCookie = accountTypeCookie
        },
        setstatecode (state, statecode) {
            state.statecode = statecode
        },
        setzipcode (state, zipcode) {
            state.zipcode = zipcode
        },
        setautopay (state, autoPay) {
            state.autoPay = autoPay
        },
        setpaperlessBilling (state, paperlessBilling) {
            state.paperlessBilling = paperlessBilling
        },
        setHasPaperlessBilling (state, value) {
            state.hasPaperlessBilling = value
        },
        setBillingEmailAddress (state, value) {
            state.billingEmailAddress = value
        },
        setEmailAddressForLogging (state, value) {
            state.emailAddressForLogging = value
        },
        setcustomerType (state, customerType) {
            state.customerType = customerType
        },
        setIsPrepaidSuspended (state, isPrepaidSuspended) {
            state.isPrepaidSuspended = isPrepaidSuspended
        },
        setIsPaymentLate (state, isPaymentLate) {
            state.isPaymentLate = isPaymentLate
        },
        SET_EmailResponse (state, emailResponse) {
            state.emailResponse = emailResponse
        },
        SET_ProfileCreatedACOD (state, acodProfile) {
            state.acodProfile = acodProfile
        },
        SET_FrgtPasswordStep1Response (state, frgtPasswordStep1Response) {
            state.frgtPasswordStep1Response = frgtPasswordStep1Response
        },
        SET_FrgtPasswordStep2Response (state, frgtPasswordStep2Response) {
            state.frgtPasswordStep2Response = frgtPasswordStep2Response
        },
        setShellProfileData (state, shellProfileData) {
            state.shellProfileData = shellProfileData
        },
        setAccountNumberAdd (state, accountNumberAdd) {
            state.accountNumberAdd = accountNumberAdd
        },
        SET_RetrieveAccountNumberResponse (state, retrieveAccountNumberResponse) {
            state.retrieveAccountNumberResponse = retrieveAccountNumberResponse
        },
        SET_tokenValidity (state, getTokenResponse) {
            state.getTokenResponse = getTokenResponse
        },
        SET_timedWork (state, timedResp) {
            state.getTimedWkResp = timedResp
        },
        SET_retrieveAuthCodeResponse (state, retrieveAuthCodeResponse) {
            state.retrieveAuthCodeResponse = retrieveAuthCodeResponse
        },
        SET_retrieveEmailorMailResponse (state, retrieveEmailorMailResponse) {
            state.retrieveEmailorMailResponse = retrieveEmailorMailResponse
        },
        SET_paTokenResponse (state, paTokenResponse) {
            state.paTokenResponse = paTokenResponse
        },
        SET_isPATokenCallSuccess (state, isPATokenCallSuccess) {
            state.isPATokenCallSuccess = isPATokenCallSuccess
        },
        SET_getChagesPasswordWithToken (state, getChagesPasswordWithToken) {
            state.getChagesPasswordWithToken = getChagesPasswordWithToken
        },
        showSuspendedAccountMessage (state, showSuspendedAccount) {
            state.showSuspendedAccount = showSuspendedAccount
        },
        showCancelOrderAlertMessage (state, showCancelOrderAlert) {
            state.showCancelOrderAlert = showCancelOrderAlert
        },
        setpaperBillChargeApplies (state, paperBillChargeApplies) {
            state.paperBillChargeApplies = paperBillChargeApplies
        },
        setCompanyOwnerId (state, companyOwnerId) {
            state.companyOwnerId = companyOwnerId
        },
        setCanShowSpinner (state, canShowSpinner) {
            state.canShowSpinner = canShowSpinner
        },
        setDisableCancelOrderButton (state, disableCancelOrderButton) {
            state.disableCancelOrderButton = disableCancelOrderButton
        },
        setRequestId (state, requestId) {
            state.requestId = requestId
        },
        setCurrentSpeed (state, currentSpeed) {
            state.currentSpeed = currentSpeed
        },
        setPaymentID (state, paymentID) {
            state.paymentID = paymentID
        },
        showRetryPaymentSuccess (state, retryPaymentSuccess) {
            state.retryPaymentSuccess = retryPaymentSuccess
        },
        offPrepaidActiveAlert (state) {
            state.showPrepaidActiveAlert = false
        },
        setPppCardStatus (state, value) {
            state.pppCardStatus = value
        },
        setIsSoftWG (state, isSoftWG) {
            state.isSoftWG = isSoftWG
        },
        setWGStatus (state, wgStatus) {
            state.wgStatus = wgStatus
        },
        setWkLocation (state, inWkLocation) {
            state.wkLocation = inWkLocation
        },
        setWorkNm (state, inWorkNm) {
            state.workNm = inWorkNm
        },
        setWorkTyp (state, inWorkTyp) {
            state.workTyp = inWorkTyp
        },
        setWrkEffort (state, inWrkEffort) {
            state.wrkEffort = inWrkEffort
        },
        setHardWG (state, wgStatus) {
            state.wgStatus = wgStatus
        },
        setIsWGStatusCallSuccess (state, isWGStatusCallSuccess) {
            state.isWGStatusCallSuccess = isWGStatusCallSuccess
        },
        setIsConnectedDevicesCallSuccess (state, isConnectedDevicesCallSuccess) {
            state.isConnectedDevicesCallSuccess = isConnectedDevicesCallSuccess
        },
        setConnectedDevicesListResponse (state, connectedDevicesListResponse) {
            state.connectedDevicesListResponse = connectedDevicesListResponse
        },
        setIsHardWG (state, isHardWG) {
            state.isHardWG = isHardWG
        },
        setIsLatPaymentDateInPeriod (state, isLatPaymentDateInPeriod) {
            state.isLatPaymentDateInPeriod = isLatPaymentDateInPeriod
        },
        setisLatePaymentDateInPeriod (state, isLatePaymentDateInPeriod) {
            state.isLatePaymentDateInPeriod = isLatePaymentDateInPeriod
        },
        setLoginId (state, loginID) {
            state.loginID = loginID
        },
        setIsWGPaymentSuccess (state, isWGPaymentSuccess) {
            state.isWGPaymentSuccess = isWGPaymentSuccess
        },
        setIsNetworkConnected (state, isNetworkConnected) {
            state.isNetworkConnected = isNetworkConnected
        },
        setIsPostChangesWithTokenSuccess (state, isPostChangesWithTokenSuccess) {
            state.isPostChangesWithTokenSuccess = isPostChangesWithTokenSuccess
        },
        setIsGetTokenSuccess (state, isGetTokenSuccess) {
            state.isGetTokenSuccess = isGetTokenSuccess
        },
        set_IsFrgtPwdStep2RespSuccessful (state, isFrgtPwdStep2RespSuccessful) {
            state.isFrgtPwdStep2RespSuccessful = isFrgtPwdStep2RespSuccessful
        },
        setRetrieveAuthCodeSuccessful (state, isRetrieveAuthCodeSuccessful) {
            state.isRetrieveAuthCodeSuccessful = isRetrieveAuthCodeSuccessful
        },
        set_IsRetrvEmailorMailResSuccessful (state, isRetrvEmailorMailResSuccessful) {
            state.isRetrvEmailorMailResSuccessful = isRetrvEmailorMailResSuccessful
        },
        set_IsFrgtPwdStep1RespSuccessful (state, isFrgtPwdStep1RespSuccessful) {
            state.isFrgtPwdStep1RespSuccessful = isFrgtPwdStep1RespSuccessful
        },
        set_IsGetEmailIDRespSuccessful (state, isGetEmailIDRespSuccessful) {
            state.isGetEmailIDRespSuccessful = isGetEmailIDRespSuccessful
        },
        set_IsRetrieveAccountNumberSuccessful (state, isRetrieveAccountNumberSuccessful) {
            state.isRetrieveAccountNumberSuccessful = isRetrieveAccountNumberSuccessful
        },
        set_IsPostUserProfileRespSuccessful (state, isPostUserProfileRespSuccessful) {
            state.isPostUserProfileRespSuccessful = isPostUserProfileRespSuccessful
        },
        setIsgetServiceDetailsSuccess (state, isgetServiceDetailsSuccess) {
            state.isgetServiceDetailsSuccess = isgetServiceDetailsSuccess
        },
        setQrlCode (state, qrlCode) {
            state.qrlCode = qrlCode
        },
        setIsRateChangeCallSuccessful (state, isRateChangeCallSuccessful) {
            state.isRateChangeCallSuccessful = isRateChangeCallSuccessful
        },
        setRateChangeResponse (state, rateChangeResponse) {
            state.rateChangeResponse = rateChangeResponse
        },
        setRateChangeNotification (state, rateChangeNotification) {
            state.rateChangeNotification = rateChangeNotification
        },
        setIsVacationSuspended (state, isVacationSuspended) {
            state.isVacationSuspended = isVacationSuspended
        },
        setCanVacationRestored (state, canVacationRestored) {
            state.canVacationRestored = canVacationRestored
        },
        setCanVacationSuspend (state, canVacationSuspend) {
            state.canVacationSuspend = canVacationSuspend
        },
        setIsVacationallySuspended (state, isVacationallySuspended) {
            state.isVacationallySuspended = isVacationallySuspended
        },
        setisBYOM (state, isBYOM) {
            state.isBYOM = isBYOM
        },
        setIsThirdPartyModem (state, isThirdPartyModem) {
            state.isThirdPartyModem = isThirdPartyModem
        },
        setNBAModemReplacement (state, nbaModemReplacement) {
            state.nbaModemReplacement = nbaModemReplacement
        },
        setNBACallDone (state, nbaCallDone) {
            state.nbaCallDone = nbaCallDone
        },
        setAccptRejectCallSuccessful (state, accptRejectCallSuccessful) {
            state.accptRejectCallSuccessful = accptRejectCallSuccessful
        },
        setIsWheresMyTechKillSwitch (state, isWheresMyTechKillSwitch) {
            state.isWheresMyTechKillSwitch = isWheresMyTechKillSwitch
        },
        setGetOrderInteractionInfo (state, getOrderInteractionInfo) {
            state.getOrderInteractionInfo = getOrderInteractionInfo
        },
        setGetOrderInteractionInfoCallSuccess (state, getOrderInteractionInfoCallSuccess) {
            state.getOrderInteractionInfoCallSuccess = getOrderInteractionInfoCallSuccess
        },
        setClickTechTrackerCallSuccess (state, clickTechTrackerCallSuccess) {
            state.clickTechTrackerCallSuccess = clickTechTrackerCallSuccess
        },
        setTech_Tracker_failed (state, inTechTrackerFailed) {
            state.tech_Tracker_failed = inTechTrackerFailed
        },
        setTechTrackerFound (state, techTrackerFound) {
            state.getTechTrackerFound = techTrackerFound
        },
        setFoundSmsMsg (state, foundSmsMsg) {
            state.foundSmsMsg = foundSmsMsg
        },
        setNBACaptureResponse (state, nbaCaptureResponse) {
            state.nbaCaptureResponse = nbaCaptureResponse
        },
        setAppKey (state, appKey) {
            state.appKey = appKey
        },
        setIsNetWorkServiceCallDoneOnce (state, isNetWorkServiceCallDoneOnce) {
            state.isNetWorkServiceCallDoneOnce = isNetWorkServiceCallDoneOnce
        },
        setDisplayErrorCreditModal (state, isDisplayErrorCreditModal) {
            state.isDisplayErrorCreditModal = isDisplayErrorCreditModal
        },
        setIsAssiaEnabled (state, isAssiaEnabled) {
            state.isAssiaEnabled = isAssiaEnabled
        },
        setHistoricalSpeeds (state, historicalSpeeds) {
            state.historicalSpeeds = historicalSpeeds
        },
        setIsDataFlowChecked (state, isDataFlowChecked) {
            state.isDataFlowChecked = isDataFlowChecked
        }
    },
    actions: {
        asideMobileToggle ({ commit, state }, payload = null) {
            const isShow = payload !== null ? payload : !state.isAsideMobileExpanded

            document.getElementById('app').classList[isShow ? 'add' : 'remove']('ml-60')

            document.documentElement.classList[isShow ? 'add' : 'remove']('m-clipped')

            commit('basic', {
                key: 'isAsideMobileExpanded',
                value: isShow
            })
        },
        formScreenToggle ({ commit, state }, payload) {
            commit('basic', {
                key: 'isFormScreen',
                value: payload
            })

            document.documentElement.classList[payload ? 'add' : 'remove']('form-screen')
        },
        async getAppKey ({ commit }) {
            try {
                const response = await axios.get(process.env.VUE_APP_SippyCup_URL)
                if (response?.data?.ip) {
                    const apiKey = `${new Date().toISOString()}|${response?.data.ip}|${process.env.VUE_APP_CRYPTO_PASSPHRASE}`
                    const key = CryptoJS.enc.Latin1.parse(process.env.VUE_APP_CRYPTO_APP_KEY)
                    const iv = CryptoJS.enc.Latin1.parse(process.env.VUE_APP_CRYPTO_APP_IV)
                    const encrypted = CryptoJS.AES.encrypt(
                        apiKey,
                        key,
                        {
                            iv: iv, mode: CryptoJS.mode.CBC, padding: CryptoJS.pad.ZeroPadding
                        })
                    commit('setAppKey', encrypted)
                } else {
                    // if calling getAppKey second time in the same session failed then we might get the older encrypted value so setting it null
                    commit('setAppKey', null)
                }
            } catch (error) {
                commit('setAppKey', null)
                console.log(' app key set to null due to failed response of VUE_APP_SippyCup_URL')
            }
        },
        async callSignIn () {
            try {
                const checkHeaderResponse = await axios.get(process.env.VUE_APP_Shandarian_BASE_URL + '/Orch/checkSHReader')
                if (checkHeaderResponse.data) {
                    console.log('**********App.vue****this.$isauthenticated**********')
                    this.state.profileID = checkHeaderResponse.data
                    window.dataLayer.push({
                        event: 'gtm.post',
                        flow: {
                            name: 'my ctl: support'
                        },
                        noninteraction: false
                    })
                }
            } catch (error) {
                console.log('Error response ' + error)
                window.dataLayer.push({
                    event: 'my_ctl_error',
                    flow: {
                        name: 'my ctl: support'
                    },
                    errorName: 'ctl|ma|support_error|checkHeader_service_error',
                    noninteraction: false
                })
            }
        },
        async check4RateChange ({ commit }) {
            console.log('checking for rate change')
            commit('setRateChangeNotification', false)
            try {
                if (this.state.accountNumber != null && this.state.isBlueMarbles) {
                    commit('setRateChangeResponse', null)
                    const retRateIncreaseCheckResp = await axios.get(
                        process.env.VUE_APP_Auth_HISTORY_URL + process.env.VUE_APP_GET_RATE_AT_RANDOM + '?accountNumber=' + this.state.accountNumber)
                    if (retRateIncreaseCheckResp != null && retRateIncreaseCheckResp?.status === 200 && retRateIncreaseCheckResp?.data?.statusInfo?.status?.toUpperCase() === 'SUCCESS') {
                        console.log('rate change check successful')
                        commit('setIsRateChangeCallSuccessful', true)
                        commit('setRateChangeResponse', retRateIncreaseCheckResp?.data)

                        const rateChngRespObj = retRateIncreaseCheckResp?.data
                        if (rateChngRespObj?.rateChangeNotification) {
                            console.log('RateChangeNotification true')
                            commit('setRateChangeNotification', true)
                        } else {
                            console.log('RateChangeNotification false')
                            commit('setRateChangeNotification', false)
                        }
                    } else {
                        console.log('rate change check returned with non success response')
                        commit('setIsRateChangeCallSuccessful', false)
                    }
                } else {
                    console.log('Not BlueMarbleAcct or acctNumber was null')
                    commit('setIsRateChangeCallSuccessful', false)
                }
            } catch (error) {
                console.log('rate change check Error response ' + error)
                commit('setIsRateChangeCallSuccessful', false)
            }
        },
        async getConnectedDevicesList ({ commit }) {
            console.log('Getting Connected Devices List')
            console.log('WTN', this.state.profiledata?.data?.wtn)
            // commit('setRateChangeNotification', false)
            try {
                if (this.state.accountNumber != null) {
                    const connectedDevicesListResp = await axios.get(
                        process.env.VUE_APP_NEW_BASE_URL + '/Orch/dssh/acs/v3/getLargeModemInfo' + '?wtn=' + this.state.profiledata?.data?.wtn + '&mock=' + process.env.VUE_APP_CONNECTED_DEVICES_MOCK)
                    if (connectedDevicesListResp != null && connectedDevicesListResp?.status === 200 && connectedDevicesListResp?.data?.statusInfo?.status?.toUpperCase() === 'SUCCESS') {
                        console.log('Connected Devices List Response Successful')
                        commit('setIsConnectedDevicesCallSuccess', true)
                        commit('setConnectedDevicesListResponse', connectedDevicesListResp?.data)
                    } else {
                        console.log('getConnectedDevicesList Returned Non Success Response')
                        commit('setIsConnectedDevicesCallSuccess', false)
                    }
                } else {
                    console.log('acctNumber was null for getConnectedDevicesList')
                    commit('setIsConnectedDevicesCallSuccess', false)
                }
            } catch (error) {
                console.log('Get Connected Devices Error ' + error)
                commit('setIsConnectedDevicesCallSuccess', false)
            }
        },
        async checkOutage ({ commit }) {
            console.log('checking outage')
            console.log('AccountNumber = ' + this.state.accountNumber)
            console.log('WTN = ' + this.state.profiledata?.data?.wtn)
            console.log('this.state.territory = ' + this.state.territory)
            console.log('this.state.profiledata?.data?.territory: ' + this.state.profiledata?.data?.territory)
            try {
                if (this.state.accountNumber) {
                    const inWtn = this.state.profiledata?.data?.wtn
                    const billingsrc = this.state.profiledata?.data?.billingSource
                    const identifierTypeVal = this.state.accountNumber?.startsWith('PPB') ? 'BAID' : 'BAN'
                    if (billingsrc != null && this.state.profiledata?.data?.territory != null) {
                        this.checkOutageResponse = await axios.get(process.env.VUE_APP_Auth_Better_days_URL + '/Orch/dssh/rx/getFirstOutageDetails?accountNumber=' + this.state.accountNumber + '&identifierType=' + identifierTypeVal + '&wtn=' + inWtn + '&legacyMarket=' + this.state.profiledata?.data?.territory + '&billingSource=' + billingsrc)
                    } else {
                        this.checkOutageResponse = await axios.get(process.env.VUE_APP_Spending_BASE_URL + '/Orch/dssh/rx/getLastOutageDetails?accountNumber=' + this.state.accountNumber + '&identifierType=' + identifierTypeVal + '&wtn=' + inWtn)
                    }
                    console.log('OutageResponse: ', this.checkOutageResponse)
                    if (this.checkOutageResponse?.data) {
                        if (this.checkOutageResponse?.data?.statusInfo?.status?.toUpperCase() === 'SUCCESS') {
                            this.state.isOutage = this.checkOutageResponse?.data?.currentOutage
                            commit('setisOutage', this.checkOutageResponse?.data?.currentOutage)
                            console.log('isOutage: ' + this.checkOutageResponse?.data?.currentOutage)
                            this.state.outageId = this.checkOutageResponse?.data?.outageId
                            commit('setOutageId', this.checkOutageResponse?.data?.outageId)
                            console.log('outageId: ' + this.checkOutageResponse?.data?.outageId)
                            this.state.outageHangover = this.checkOutageResponse?.data?.outageHangover
                            commit('setOutageHangover', this.checkOutageResponse?.data?.outageHangover)
                            console.log('outageHangover: ' + this.checkOutageResponse?.data?.outageHangover)
                            this.state.outageRebootModem = this.checkOutageResponse?.data?.rebootModem
                            commit('setOutageRebootModem', this.checkOutageResponse?.data?.rebootModem)
                            console.log('rebootModem: ' + this.checkOutageResponse?.data?.rebootModem)
                            this.state.outageEstRepairTime = this.checkOutageResponse?.data?.estRepairTime?.dateTime
                            commit('setOutageEstRepairTime', this.checkOutageResponse?.data?.estRepairTime?.dateTime)
                            // setting value for testing purpose
                            // commit('setOutageEstRepairTime', '11-01-2023 1:39:55')
                            console.log('estRepairTime: ' + this.checkOutageResponse?.data?.estRepairTime?.dateTime)

                            commit('setWkLocation', 'store_index')
                            commit('setWorkNm', 'OutageResponse success')
                            commit('setWorkTyp', this.state.outageId)
                            commit('setWrkEffort', 0)
                            this.dispatch('trackUiIssue')
                        } else {
                            commit('setisOutage', false)
                            commit('setOutageHangover', false)
                            commit('setOutageRebootModem', false)

                            commit('setWkLocation', 'store_index')
                            commit('setWorkNm', 'STATUS VALUE IS NOT SUCCESS')
                            commit('setWorkTyp', `OutageResponse status ${this.checkOutageResponse?.data?.statusInfo?.status?.toUpperCase()}`)
                            commit('setWrkEffort', 0)
                            this.dispatch('trackUiIssue')
                        }
                    }
                } else {
                    commit('setisOutage', false)
                    commit('setOutageHangover', false)
                    commit('setOutageRebootModem', false)
                    // commit('setOutageEstRepairTime', '10-31-2023 1:39:55')

                    commit('setWkLocation', 'store_index')
                    commit('setWorkNm', 'ACCOUNT NUMBER NOT FOUND')
                    commit('setWorkTyp', 'Account Number do not exist in store')
                    commit('setWrkEffort', 0)
                    this.dispatch('trackUiIssue')
                }
            } catch (error) {
                commit('setisOutage', false)
                commit('setOutageHangover', false)
                commit('setOutageRebootModem', false)
                // commit('setOutageEstRepairTime', '10-31-2023 1:39:55')

                commit('setWkLocation', 'store_index')
                commit('setWorkNm', 'ERROR FETCHING OUTAGE DETAILS')
                commit('setWorkTyp', error)
                commit('setWrkEffort', 0)
                this.dispatch('trackUiIssue')
            }
        },
        async getProfileId ({ commit }) {
            try {
                const getProfileFromRequest = await axios.get(process.env.VUE_APP_CERTANTY_BASE_URL + '/Orch/dssh/getOURProfileFromRequest')
                console.log('getProfileFromRequest success')
                commit('SET_ITEMS', getProfileFromRequest.data)
                if (getProfileFromRequest?.data?.currentlyManagingPId) {
                    this.state.currentManagingPId = getProfileFromRequest.data.currentlyManagingPId
                    commit('setCurrentManagingPId', this.state.currentManagingPId)
                }
                window.dataLayer.push({
                    event: 'gtm.post',
                    flow: {
                        name: 'my ctl: support'
                    },
                    noninteraction: false
                })
            } catch (error) {
                console.log('Error response: ' + error)
                commit('SET_ITEMS', 'error')
                window.dataLayer.push({
                    event: 'my_ctl_error',
                    flow: {
                        name: 'my ctl: support'
                    },
                    errorName: 'ctl|ma|support_error|getprofile_service_error',
                    noninteraction: false
                })
            }
        },
        async postUserProfile ({ commit }, [userProfile]) {
            if (userProfile == null || userProfile === '') {
                commit('set_IsPostUserProfileRespSuccessful', false)
                console.log('postUserProfile invalid input ')
            } else {
                try {
                    const headers = {
                        AppKey: this.state.appKey
                    }
                    const profileResponse = await axios.post(process.env.VUE_APP_Vampire_BASE_URL + '/preauth/dssh/Orch/forgotFlow/ACORDIAN/createProfile2', userProfile, { headers: headers })
                    commit('SET_ProfileCreatedACOD', profileResponse.data)
                    commit('set_IsPostUserProfileRespSuccessful', true)
                } catch (err) {
                    commit('set_IsPostUserProfileRespSuccessful', false)
                    console.log('Post create profile ' + err)
                }
            }
        },
        async getEmailID ({ commit }, [email]) {
            if (email == null || email === '') {
                commit('set_IsGetEmailIDRespSuccessful', false)
                console.log('getEmailID invalid input ')
            } else {
                try {
                    const headers = {
                        AppKey: this.state.appKey
                    }
                    const emailResponse = await axios.get(process.env.VUE_APP_NotUsed_BASE_URL + '/preauth/dssh/Orch/forgotFlow/getForgottenPlanet?email=' + email, { headers: headers })
                    commit('SET_EmailResponse', emailResponse?.data)
                    commit('set_IsGetEmailIDRespSuccessful', true)
                } catch (error) {
                    commit('set_IsGetEmailIDRespSuccessful', false)
                    console.log('Email response: ' + error)
                }
            }
        },
        async retrieveAccountNumber ({ commit }, [email]) {
            if (email != null && email !== '') {
                try {
                    const headers = {
                        AppKey: this.state.appKey
                    }
                    const retrieveAccountNumberResponse = await axios.get(process.env.VUE_GHOST_BASE_URL + '/preauth/dssh/Orch/forgotFlow/getAcctNum?email=' + email, { headers: headers })
                    console.log(retrieveAccountNumberResponse)
                    commit('SET_Response', retrieveAccountNumberResponse?.data)
                    commit('set_IsRetrieveSuccessful', true)
                } catch (error) {
                    commit('set_IsRetrieveSuccessful', false)
                    console.log('Email response: ' + error)
                }
            } else {
                commit('set_IsRetrieveSuccessful', false)
            }
        },
        async getPAToken ({ commit }) {
            const biller = this.state.profiledata?.data?.currentlyManagedAccount.length === 9 ? 1 : 2
            const firstName = this.state.profiledata?.data?.firstName
            const lastName = this.state.profiledata?.data?.lastName
            const accountNumber = this.state.profiledata?.data?.currentlyManagedAccount
            const autoPay = this.state.profiledata?.data?.autoPay
            const paymentDueDate = this.state.profiledata?.data?.billDueDate
            const adjustedAmount = this.state.profiledata?.data?.currentAmountDue
            const confirmationEmailAddress = this.state.profiledata?.data?.billingEmailAddress ? this.state.profiledata?.data?.billingEmailAddress : this.state.profiledata?.data?.profile?.response?.identity?.emailAddress
            const billingAddressPrimaryLine = this.state.profiledata?.data?.billingAddress?.primaryLine
            const billingAddressCity = this.state.profiledata?.data?.billingAddress?.city
            const billingAddressStateCode = this.state.profiledata?.data.billingAddress?.stateCode
            const billingAddressZip = this.state.profiledata?.data?.billingAddress?.zip
            const billingAddressAddressLine1 = this.state.profiledata?.data?.billingAddress?.addressLine1
            const billingAddressAddressLine2 = this.state.profiledata?.data?.billingAddress?.addressLine2
            const companyOwnerId = this.state.profiledata?.data?.companyIdentifier ? this.state.profiledata?.data?.companyIdentifier : '1'
            const payload = {
                list: {
                    attributeList: [
                        {
                            name: 'biller',
                            value: biller
                        },
                        {
                            name: 'firstName',
                            value: firstName
                        },
                        {
                            name: 'lastName',
                            value: lastName
                        },
                        {
                            name: 'accountNumber',
                            value: accountNumber
                        },
                        {
                            name: 'autoPay',
                            value: autoPay
                        },
                        {
                            name: 'paymentDueDate',
                            value: paymentDueDate
                        },
                        {
                            name: 'adjustedAmount',
                            value: adjustedAmount
                        },
                        {
                            name: 'confirmationEmailAddress',
                            value: confirmationEmailAddress
                        },
                        {
                            name: 'billingAddressPrimaryLine',
                            value: billingAddressPrimaryLine
                        },
                        {
                            name: 'billingAddressCity',
                            value: billingAddressCity
                        },
                        {
                            name: 'billingAddressStateCode',
                            value: billingAddressStateCode
                        },
                        {
                            name: 'billingAddressZip',
                            value: billingAddressZip
                        },
                        {
                            name: 'billingAddressAddressLine1',
                            value: billingAddressAddressLine1
                        },
                        {
                            name: 'billingAddressAddressLine2',
                            value: billingAddressAddressLine2
                        },
                        {
                            name: 'companyOwnerId',
                            value: companyOwnerId
                        }
                    ]
                }
            }
            console.log('getPAToken Payload ', payload)
            try {
                const paToken = await axios.post(`${process.env.VUE_APP_Auth_SPOOKY_URL}${process.env.VUE_APP_CREATE_JUMPOUT_PATH}`, payload)
                console.log('SET_paTokenResponse ', paToken)
                commit('SET_paTokenResponse', paToken?.data)
                commit('SET_isPATokenCallSuccess', true)
            } catch (error) {
                console.log('PA token: ' + error)
                commit('SET_isPATokenCallSuccess', false)
                this.$toast.add({ severity: 'error', detail: 'We are unable to provide this function at this time. Please try again later.', life: 4001 })
            }
        },
        async getForgotPasswordStep1 ({ commit }, [frgtUsername]) {
            if (frgtUsername == null || frgtUsername === '') {
                commit('set_IsFrgtPwdStep1RespSuccessful', false)
                console.log('Forgot Password step 1:  missing input')
            } else {
                try {
                    const headers = {
                        AppKey: this.state.appKey
                    }
                    console.log('header' + headers)
                    const frgtPasswordStep1Response = await axios.get(process.env.VUE_APP_Auth_OOKY_URL + '/preauth/dssh/Orch/forgotFlow/getForgotPwd?login=' + frgtUsername, { headers: headers })
                    commit('SET_FrgtPasswordStep1Response', frgtPasswordStep1Response?.data)
                    commit('set_IsFrgtPwdStep1RespSuccessful', true)
                } catch (error) {
                    commit('set_IsFrgtPwdStep1RespSuccessful', false)
                    console.log('Forgot Password step 1: ' + error)
                }
            }
        },
        async getForgotPasswordStep2 ({ commit }, [params]) {
            try {
                const headers = {
                    AppKey: this.state.appKey
                }
                console.log('header' + headers)
                const frgtPasswordStep2Response = await axios.post(process.env.VUE_APP_Auth_SCIENCY_URL + '/preauth/dssh/Orch/forgotFlow/checkEmailForgotPwd', params, { headers: headers })
                commit('SET_FrgtPasswordStep2Response', frgtPasswordStep2Response?.data)
                commit('set_IsFrgtPwdStep2RespSuccessful', true)
            } catch (error) {
                commit('set_IsFrgtPwdStep2RespSuccessful', false)
                console.log('Forgot Password step 2: ' + error)
            }
        },
        async getRetrieveAuthCode ({ commit }, [accountNumber]) {
            try {
                const headers = {
                    AppKey: this.state.appKey
                }
                console.log('header' + headers)
                const retrieveAuthCodeResponse = await axios.get(process.env.VUE_APP_Auth_Surprise_URL + '/preauth/dssh/Orch/forgotFlow/getAuthCode?acctNum=' + accountNumber, { headers: headers })
                commit('SET_getAuthCodeResponse', retrieveAuthCodeResponse?.data)
                commit('setGetAuthCodeSuccessful', true)
            } catch (error) {
                console.log('get Auth Code: ' + error)
                commit('setGetAuthCodeSuccessful', false)
            }
        },
        async getRetrieveEmailorMail ({ commit }, [requestBody]) {
            if (requestBody != null) {
                try {
                    const retrieveEmailorMailResponse = await axios.post(process.env.VUE_APP_Auth_GHOST_URL + '/preauth/dssh/Orch/forgotFlow/authCode', requestBody)
                    commit('SET_EmailorMagetAuthCodeResponse', retrieveEmailorMailResponse?.data)
                    console.log('Get Auth Code: ' + error)
                    commit('set_IsRetrvEmailorMailResSuccessful', false)
                }
            } else {
                commit('set_IsRetrvEmailorMailResSuccessful', false)
            }
        },
        async getToken ({ commit }, [token]) {
            if (token == null || token === '') {
                commit('setIsGetTokenSuccess', false)
            } else {
                try {
                    const getTokenResponse = await axios.get(process.env.VUE_APP_Auth_HOME_URL + '/preauth/dssh/Orch/resetPasswordWithToken?token=' + token)
                    commit('SET_tokenValidity', getTokenResponse?.data)
                    commit('setIsGetTokenSuccess', true)
                } catch (error) {
                    commit('setIsGetTokenSuccess', false)
                    console.log(error)
                }
            }
        },
        async postChagesPasswordWithToken ({ commit }, [requestBody]) {
            try {
                const getChagesPasswordWithToken = await axios.post(process.env.VUE_APP_Auth_HOME_URL + '/preauth/dssh/orch/ecom/changePasswordWithToken', requestBody)
                commit('SET_getChagesPasswordWithToken', getChagesPasswordWithToken?.data)
                commit('setIsPostChangesWithTokenSuccess', true)
            } catch (error) {
                commit('setIsPostChangesWithTokenSuccess', false)
                console.log(error)
            }
        },
        async trackUiIssue ({ commit }) {
            console.log('trackUiIssue start')
            if (this.profiledataa?.data?.currentlyManagedAccount != null && this.profiledataa?.data?.currentlyManagedAccount !== '') {
                commit('setAccountNumber', this.profiledataa?.data?.currentlyManagedAccount)
            } else if (this.state.accountNumber != null && this.state.accountNumber !== '') {
                commit('setAccountNumber', this.state.accountNumber)
            } else {
                commit('setAccountNumber', null)
            }
            const startTime = new Date()
            if (this.state.emailAddressForLogging === null || this.state.emailAddressForLogging === '' || this.state.emailAddressForLogging === undefined) {
                if (this.profiledataa?.data?.emailAddress) {
                    commit('setEmailAddressForLogging', this.profiledataa?.data?.emailAddress)
                } else if (this.profiledataa?.data?.billingEmailAddress) {
                    commit('setEmailAddressForLogging', this.profiledataa?.data?.billingEmailAddress)
                } else if (this.profiledataa?.data?.profile?.response?.identity?.emailAddress) {
                    commit('setEmailAddressForLogging', this.profiledataa?.data?.profile?.response?.identity?.emailAddress)
                }
            }
            try {
                const params = {
                    accountNumber: this.state.accountNumber,
                    emailAddress: this.state.emailAddressForLogging,
                    page: this.state.wkLocation,
                    operation: this.state.workNm,
                    message: this.state.workTyp,
                    level: this.state.wrkEffort
                }
                const retrievePostAuthWorkTimeResp = await axios.post(process.env.VUE_APP_Auth_LEGAL_URL + process.env.VUE_APP_WORK_MEASURING_URL, params)
                commit('SET_timedWork', retrievePostAuthWorkTimeResp)
            } catch (error) {
                console.log('trackUiIssue error = ' + error)
            }

            const endTime = new Date()
            console.log('Index.js duration is {}', endTime - startTime)
        },
        async getOrderHistoryDetails ({ commit }) {
            try {
                const orderhistorydata = await axios.get(process.env.VUE_APP_Auth_HOME_URL + '/Orch/dssh/c360/getOrders?accountNumber=' + this.state.profiledata?.data?.currentlyManagedAccount)
                console.log('order history response details', orderhistorydata)
                commit('setorderhistories', orderhistorydata)
            } catch (error) {
                console.log('error for order history', error)
                commit('setorderhistories', 'failureresp')
            }
        },
        paymentJumpout ({ commit }) {
            try {
                if (this.state.accountNumber != null) {
                    console.log('paymentJumpout')
                    commit('setWkLocation', 'store_index')
                    commit('setWorkNm', 'Pay Bill jumpout success on account number :')
                    commit('setWorkTyp', this.state.accountNumber)
                    commit('setWrkEffort', 0)
                    this.dispatch('trackUiIssue')
                    console.log(process.env.VUE_APP_HOME_DOMAIN + process.env.VUE_APP_JUMP_TO_BASE + this.state.accountNumber)
                    window.location.href = process.env.VUE_APP_HOME_DOMAIN + process.env.VUE_APP_JUMP_TO_BASE + this.state.accountNumber
                    return 'success'
                } else {
                    console.log('else')
                    commit('setWkLocation', 'store_index')
                    commit('setWorkNm', 'Pay Bill jumpout failure due to null account')
                    commit('setWorkTyp', this.state.accountNumber)
                    commit('setWrkEffort', 0)
                    this.dispatch('trackUiIssue')
                    return 'error'
                }
            } catch (error) {
                console.log('else exception')
                console.log(error)
                commit('setWkLocation', 'store_index')
                commit('setWorkNm', 'Pay Bill jumpout failure ')
                commit('setWorkTyp', error)
                commit('setWrkEffort', 0)
                this.dispatch('trackUiIssue')
                return 'error'
            }
        },
        async getprofiledata ({ commit }) {
            try {
                console.log('Calling webservice: getprofiledata')
                this.state.territory = null
                commit('setterritory', null)
                commit('setWkLocation', 'store_index')
                commit('setWorkNm', 'getprofiledata')
                commit('setWorkTyp', 'retrieved profile')
                commit('setWrkEffort', 0)

                const getprofiledataforhome = await axios.get(process.env.VUE_APP_Auth_HOME_URL + '/Orch/dssh/home')
                console.log('Home Early Init Headers')
                if (getprofiledataforhome.data.statusCode === -7) {
                    commit('setprofileDataHome', 'failure')
                    if (!this.state?.isDataFlowChecked) {
                        commit('setWkLocation', 'store_index')
                        commit('setWorkNm', 'getprofiledata')
                        commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, but failed to get profile data. Username is' + this.state.username)
                        commit('setWrkEffort', 0)
                        this.dispatch('trackUiIssue')
                        commit('setIsDataFlowChecked', true)
                    }
                    commit('setisBrightspeedCustomer', false)
                    this.state.isBrightspeedCustomer = false
                    window.dataLayer.push({
                        event: 'my_ctl_error',
                        flow: {
                            name: 'my ctl: home'
                        },
                        errorName: 'ctl|ma|account|home_error|account_profile_data_error',
                        noninteraction: false
                    })
                } else if (getprofiledataforhome.data.statusCode === 222 && getprofiledataforhome.data.response) {
                    window.location.href = getprofiledataforhome.data.response
                } else if (getprofiledataforhome?.data?.status === '223') {
                    if (!this.state?.isDataFlowChecked) {
                        commit('setWkLocation', 'store_index')
                        commit('setWorkNm', 'getHsiInfo')
                        commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, but redirected away from home page. Username is' + this.state.username)
                        commit('setWrkEffort', 0)
                        this.dispatch('trackUiIssue')
                        commit('setIsDataFlowChecked', true)
                    }
                    commit('setprofileDataHome', '223')
                    commit('setLoginId', getprofiledataforhome)
                    console.log('No accounts associated to the profile. Redirect to Add an account screen.', getprofiledataforhome)
                    // window.location.href = process.env.VUE_APP_AUTH_REDIRECT_URI + 'AddAnAccountNumber'
                } else {
                    console.log('Response not null')
                    if (!getprofiledataforhome.data.accountLifeCycle) {
                        if (!this.state?.isDataFlowChecked) {
                            commit('setWkLocation', 'store_index')
                            commit('setWorkNm', 'getprofiledata')
                            commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, but accountLifeCycle is unknown. Username is' + this.state.username)
                            commit('setWrkEffort', 0)
                            this.dispatch('trackUiIssue')
                            commit('setIsDataFlowChecked', true)
                        }
                        console.log('failure')
                        commit('setprofileDataHome', 'failure')
                        commit('setisBrightspeedCustomer', false)
                        this.state.isBrightspeedCustomer = false
                    } else {
                        console.log('success')
                        console.log('getprofiledataforhome', getprofiledataforhome)
                        commit('setWkLocation', 'store_index')
                        commit('setWorkNm', 'getprofiledata')
                        commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, TEST SUCCESS MESSAGE:  Username is' + this.state.username)
                        commit('setWrkEffort', 0)
                        this.dispatch('trackUiIssue')
                        if (getprofiledataforhome?.data) {
                            if (getprofiledataforhome.data?.earlyAccessProductOrderResponse?.earlyAccessProductOrderResponse?.orderStatus?.toLowerCase() === 'in progress' && process.env.VUE_APP_TECH_TRACKER === 'false') {
                                this.state.showSMScomm = true
                                commit('setShow_SMS_comm', true)
                            } else {
                                this.state.showSMScomm = false
                                commit('setShow_SMS_comm', false)
                            }
                            this.jobstat = getprofiledataforhome.data?.earlyAccessProductOrderResponse?.earlyAccessProductOrderResponse?.jobStatus?.toLowerCase()
                            if (this.state.showSMScomm && (this.jobstat === 'enroute') && process.env.VUE_APP_TECH_TRACKER === 'false') {
                                commit('setShow_tech_tracker', true)
                            } else {
                                commit('setShow_tech_tracker', false)
                            }
                            console.log('jobStatus')
                            console.log(getprofiledataforhome.data?.earlyAccessProductOrderResponse?.earlyAccessProductOrderResponse?.jobStatus?.toLowerCase())
                            console.log(this.state.showSMScomm)
                            console.log(process.env.VUE_APP_TECH_TRACKER)
                            if (this.state.showSMScomm && this.jobstat !== 'enroute' && this.jobstat !== 'on-site' && process.env.VUE_APP_TECH_TRACKER === 'false') {
                                commit('setshowApptmsg', true)
                                console.log('setshowApptmsg true')
                            } else {
                                commit('setshowApptmsg', false)
                                console.log('setshowApptmsg false')
                            }
                            console.log('Index.js TEMP postTimingInfo')
                            if (getprofiledataforhome?.data?.currentlyManagedAccount != null && getprofiledataforhome?.data?.currentlyManagedAccount !== '') {
                                commit('setAccountNumber', getprofiledataforhome?.data?.currentlyManagedAccount)
                            } else {
                                commit('setAccountNumber', null)
                            }

                            const curCompId = getprofiledataforhome?.data?.companyIdentifier
                            if ((!!curCompId) && (curCompId === '4')) {
                                console.log('Brightspeed message toggled ON.')
                                commit('setisBrightspeedCustomer', true)
                                this.state.isBrightspeedCustomer = true
                            } else {
                                console.log('Brightspeed message toggled OFF.')
                                commit('setisBrightspeedCustomer', false)
                                this.state.isBrightspeedCustomer = false
                            }
                            if (getprofiledataforhome?.data?.qrlCode) {
                                commit('setQrlCode', getprofiledataforhome.data.qrlCode)
                            }
                        }
                        if (getprofiledataforhome?.data?.currentlyManagedAccount.startsWith('PPB') && getprofiledataforhome?.data?.accountStatus === 'INACTIVE') {
                            console.log('Prepaid InActive account true')
                            commit('setIsPrepaidInactive', true)
                        } else {
                            console.log('Prepaid InActive account false')
                            commit('setIsPrepaidInactive', false)
                        }
                        if (getprofiledataforhome?.data?.currentlyManagedAccount.startsWith('PPB') && getprofiledataforhome?.data?.accountStatus?.toUpperCase() === 'ACTIVE' && getprofiledataforhome?.data?.creditCardExpiryDate != null) {
                            const today = new Date()
                            const futureDate = new Date(new Date().setDate(today.getDate() + 60))
                            const cardExDate = new Date(getprofiledataforhome?.data?.creditCardExpiryDate)
                            if (cardExDate < today) {
                                commit('setPppCardStatus', 1)
                            } else if (futureDate > cardExDate) {
                                commit('setPppCardStatus', 2)
                            }
                        }
                        if (getprofiledataforhome?.data?.currentlyManagedAccount.startsWith('PPB')) {
                            this.accountTypeCookie = 'PrePaid'
                            commit('setaccountTypeCookie', 'PrePaid')
                        } else {
                            this.accountTypeCookie = 'PostPaid'
                            commit('setaccountTypeCookie', 'PostPaid')
                        }
                        if (getprofiledataforhome?.data?.isVacationSuspend) {
                            commit('setIsVacationallySuspended', 'true')
                        } else {
                            commit('setIsVacationallySuspended', 'false')
                        }
                        const show3DayGraceAlert = process.env.VUE_APP_DISPLAY_3DAY_GRACE
                        if (getprofiledataforhome?.data?.currentlyManagedAccount.startsWith('PPB') && show3DayGraceAlert === 'true') {
                            try {
                                axios.get(`${process.env.VUE_APP_Auth_BASE_URL}/Orch/dssh/aos/ppp/getWGStatus?baid=${getprofiledataforhome?.data?.currentlyManagedAccount}`).then(serviceresponse => {
                                    console.log('Has WG isSoftWG ', serviceresponse.data.response)
                                    if (serviceresponse.data.response.isSoftWG === 'false' || serviceresponse.data.response.wgstatus === 'false') {
                                        commit('setIsSoftWG', false)
                                        commit('setWGStatus', false)
                                        commit('setIsHardWG', true)
                                    } else {
                                        const currentDate = new Date()
                                        currentDate.setHours(0, 0, 0, 0)
                                        const diffTime = Math.abs(currentDate - new Date(getprofiledataforhome?.data?.failedPaymentDate).setHours(0, 0, 0, 0))
                                        const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24))
                                        console.log('Has WG diffDays ', diffDays)
                                        if (diffDays <= 3) {
                                            commit('setIsLatPaymentDateInPeriod', true)
                                        } else {
                                            commit('setIsLatPaymentDateInPeriod', false)
                                        }
                                        if (serviceresponse.data.response.isSoftWG === 'true' && serviceresponse.data.response.wgstatus === 'true' && diffDays <= 3 && getprofiledataforhome?.data?.creditCardType) {
                                            commit('setIsSoftWG', true)
                                            commit('setWGStatus', true)
                                            commit('setIsHardWG', false)
                                        } else {
                                            commit('setIsSoftWG', false)
                                            commit('setWGStatus', false)
                                            commit('setIsHardWG', true)
                                        }
                                    }
                                    commit('setIsWGStatusCallSuccess', 'success')
                                    // commit('setIsWGServiceCallDone', true)
                                }).catch(error => {
                                    commit('setIsSoftWG', false)
                                    commit('setWGStatus', false)
                                    commit('setIsHardWG', true)
                                    commit('setIsWGStatusCallSuccess', 'failure')
                                    console.log(error)
                                })
                            } catch (error) {
                                commit('setIsSoftWG', false)
                                commit('setWGStatus', false)
                                commit('setIsHardWG', true)
                                commit('setIsWGStatusCallSuccess', 'failure')
                                console.log(error)
                            }
                        } else {
                            commit('setIsHardWG', true)
                        }
                        if (getprofiledataforhome?.data?.serviceAddress?.stateCode) {
                            this.state.statecode = getprofiledataforhome.data.serviceAddress.stateCode
                            commit('setstatecode', getprofiledataforhome.data.serviceAddress.stateCode)
                        } else {
                            this.state.statecode = 'Unknown'
                            commit('setstatecode', 'Unknown')
                        }
                        if (getprofiledataforhome?.data?.serviceAddress?.zip) {
                            this.state.zipcode = getprofiledataforhome.data.serviceAddress.zip
                            commit('setzipcode', getprofiledataforhome.data.serviceAddress.zip)
                        }
                        if (getprofiledataforhome?.data?.autoPay === true) {
                            this.state.autoPay = 'Yes'
                            commit('setautopay', 'Yes')
                        } else if (getprofiledataforhome?.data?.autoPay === false) {
                            this.state.autoPay = 'No'
                            commit('setautopay', 'No')
                        }
                        if (getprofiledataforhome?.data?.paperlessBilling === true) {
                            this.state.paperlessBilling = 'Yes'
                            this.state.hasPaperlessBilling = true
                            commit('setpaperlessBilling', 'Yes')
                        } else if (getprofiledataforhome?.data?.paperlessBilling === false) {
                            this.state.paperlessBilling = 'No'
                            commit('setpaperlessBilling', 'No')
                        }
                        if (getprofiledataforhome?.data?.billingEmailAddress) {
                            this.state.billingEmailAddress = getprofiledataforhome.data.billingEmailAddress
                        }
                        if (getprofiledataforhome?.data?.emailAddress) {
                            commit('setEmailAddressForLogging', getprofiledataforhome?.data?.emailAddress)
                        } else if (getprofiledataforhome?.data?.billingEmailAddress) {
                            commit('setEmailAddressForLogging', getprofiledataforhome?.data?.billingEmailAddress)
                        } else if (getprofiledataforhome?.data?.profile?.response?.identity?.emailAddress) {
                            commit('setEmailAddressForLogging', getprofiledataforhome?.data?.profile?.response?.identity?.emailAddress)
                        }
                        const startTime = new Date()
                        try {
                            const params = {
                                accountNumber: this.state.accountNumber,
                                emailAddress: this.state.emailAddressForLogging,
                                page: this.state.wkLocation,
                                operation: this.state.workNm,
                                message: this.state.workTyp,
                                level: this.state.wrkEffort
                            }
                            const retrievePostAuthWorkTimeResp = await axios.post(process.env.VUE_APP_Auth_BASE_URL + process.env.VUE_APP_WORK_MEASURING_URL, params)
                            commit('SET_timedWork', retrievePostAuthWorkTimeResp)
                        } catch (error) {
                            console.log('measuredWork error = ' + error)
                        }

                        const endTime = new Date()
                        console.log('Index.js duration is {}', endTime - startTime)

                        if (getprofiledataforhome?.data?.currentlyManagedAccount.startsWith('PPB') && getprofiledataforhome?.data?.accountStatus === 'SUSPENDED') {
                            console.log('Prepaid Suspended account true')
                            commit('setIsPrepaidSuspended', true)
                        } else {
                            console.log('Prepaid InActive account false')
                            commit('setIsPrepaidSuspended', false)
                        }
                        if (getprofiledataforhome?.data?.scheduledPayments != null) {
                            this.state.schdPymtList = getprofiledataforhome?.data?.scheduledPayments
                            commit('setSchedList', getprofiledataforhome?.data?.scheduledPayments)
                        } else {
                            this.state.schdPymtList = null
                            commit('setSchedList', null)
                        }
                        if (getprofiledataforhome?.data?.billDueDate && getprofiledataforhome?.data?.currentAmountDue) {
                            const currenDate = new Date().setHours(0, 0, 0, 0)
                            const timestamp = getprofiledataforhome?.data?.billDueDate
                            const billdate = new Date(timestamp)
                            billdate.setDate(billdate.getDate() + 1)
                            console.log('Due Date and amount ', billdate, getprofiledataforhome?.data?.currentAmountDue)
                            const billDueDate = new Date(billdate).setHours(0, 0, 0, 0)
                            if (getprofiledataforhome?.data?.currentAmountDue > 10 && currenDate > billDueDate) {
                                this.state.isPaymentLate = true
                            } else {
                                this.state.isPaymentLate = false
                            }
                            console.log(this.state.isPaymentLate)
                            const diffTime = Math.abs(currenDate - billDueDate)
                            const differenceDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24))
                            console.log('Has diffDays ', differenceDays)
                            if ((differenceDays <= 3) && getprofiledataforhome?.data?.autoPay === true) {
                                this.state.isLatePaymentDateInPeriod = false
                                commit('setisLatePaymentDateInPeriod', false)
                            } else if (differenceDays > 0 && getprofiledataforhome?.data?.autoPay === false) {
                                this.state.isLatePaymentDateInPeriod = true
                                commit('setisLatePaymentDateInPeriod', true)
                            } else if (differenceDays > 3 && getprofiledataforhome?.data?.autoPay === true) {
                                this.state.isLatePaymentDateInPeriod = true
                                commit('setisLatePaymentDateInPeriod', true)
                            } else {
                                this.state.isLatePaymentDateInPeriod = false
                                commit('setisLatePaymentDateInPeriod', false)
                            }
                            console.log('this.state.isLatePaymentDateInPeriod : ' + this.state.isLatePaymentDateInPeriod)
                        } else {
                            this.state.isPaymentLate = false
                        }
                        if (getprofiledataforhome?.data?.profile?.response?.identity) {
                            this.state.profileID = getprofiledataforhome.data.profile.response.identity.login
                        }
                        if (getprofiledataforhome?.data) {
                            this.state.isBlueMarble = getprofiledataforhome.data.c2e
                            this.state.accountNumber = getprofiledataforhome.data.currentlyManagedAccount
                        }
                        if (getprofiledataforhome?.data?.accountLifeCycle === 'Early Life' && getprofiledataforhome?.data?.earlyAccessProductOrderResponse?.earlyAccessProductOrderResponse?.hasBYOM === true) {
                            this.state.isBYOM = true
                            commit('setisBYOM', this.state.isBYOM)
                            console.log('BYOM IS TRUE FROM HOMEINIT', this.state.isBYOM)
                        }
                        if (getprofiledataforhome?.data?.accountLifeCycle === 'Early Life' && getprofiledataforhome?.data?.earlyAccessProductOrderResponse?.earlyAccessProductOrderResponse?.hasHSI === true) {
                            this.state.isHsiOwned = true
                            commit('setIsHsiOwned', true)
                            console.log('HSI IS TRUE FROM HOMEINIT', this.state.isHsiOwned)
                        }
                        if (getprofiledataforhome?.data?.currentlyManagedAccount?.length === 13) {
                            this.state.billingEntity = 'CRIS'
                            commit('setbillingEntity', this.state.billingEntity)
                        } else if (this.state.isBlueMarble === false && getprofiledataforhome?.data?.currentlyManagedAccount?.length === 9) {
                            this.state.billingEntity = 'ENSEMBLE'
                            commit('setbillingEntity', 'ENSEMBLE')
                        } else if (this.state.isBlueMarble === true && getprofiledataforhome?.data?.territory) {
                            this.state.billingEntity = 'BM-' + getprofiledataforhome.data.territory
                            commit('setbillingEntity', this.state.billingEntity)
                        } else if (this.state.isBlueMarble === false) {
                            if (getprofiledataforhome?.data?.territory === 'LC') {
                                this.state.billingEntity = 'ENSEMBLE'
                                commit('setbillingEntity', 'ENSEMBLE')
                            } else if (getprofiledataforhome?.data?.territory === 'LQ') {
                                this.state.billingEntity = 'CRIS'
                                commit('setbillingEntity', 'CRIS')
                            }
                        }
                        if (getprofiledataforhome?.data?.territory === 'LC') {
                            this.state.territory = 'L-CTL'
                            commit('setterritory', 'L-CTL')
                        } else if (this.state.profiledata?.data?.territory === 'LQ') {
                            this.state.territory = 'L-Q'
                            commit('setterritory', 'L-Q')
                        }
                        if (getprofiledataforhome?.data?.altTelephoneNumbers?.length > 0) {
                            console.log('Alternate phone number array is not empty.')
                            this.state.hasalternateTelephoneNumber = true
                        }
                        if (getprofiledataforhome?.data?.accountType) {
                            console.log('accountType ', getprofiledataforhome.data.accountType)
                            this.state.accountType = getprofiledataforhome.data.accountType
                            if (getprofiledataforhome.data.accountType === 'I' || getprofiledataforhome.data.accountType === 'CX' || getprofiledataforhome.data.accountType === 'H') {
                                this.state.customerType = 'RES'
                                commit('setcustomerType', 'RES')
                                console.log('commited account type as RES')
                            } else if (getprofiledataforhome.data.accountType === 'B' || getprofiledataforhome.data.accountType === 'CXSB') {
                                this.state.customerType = 'SMB'
                                commit('setcustomerType', 'SMB')
                                console.log('commited account type as SMB')
                            }
                        }
                        if (getprofiledataforhome?.data?.voicemailCTA) {
                            console.log('voicemailCTA', getprofiledataforhome.data.voicemailCTA)
                            this.state.voicemailCTA = getprofiledataforhome.data.voicemailCTA
                            commit('setVoicemailCTA', this.state.voicemailCTA)
                        } else {
                            this.state.voicemailCTA = false
                            commit('setVoicemailCTA', this.state.voicemailCTA)
                        }
                        if (getprofiledataforhome?.data?.nextPaymentAmount) {
                            console.log('nextPaymentAmount ', getprofiledataforhome.data.nextPaymentAmount)
                            this.state.nextPaymentAmount = getprofiledataforhome.data.nextPaymentAmount
                            commit('setnextPaymentAmount', getprofiledataforhome.data.nextPaymentAmount)
                        }
                        commit('setprofileDataHome', getprofiledataforhome)
                        commit('sethomeEarlyInitResponseHeaders', getprofiledataforhome.headers)
                    }
                    // NO NEED OF STUBBING NOW, so commneting it out.
                    // if (getprofiledataforhome.data.earlyAccessProductOrderResponse == null) {
                    // console.log('Stubbing c360 data')
                    // ******stubbing earlyproductgetprofiledatadummy is temporary untill earlyAccessProductOrderResponse data actual returning back***************
                    // const earlyproductgetprofiledatadummy = { earlyAccessProductOrderResponse: { orderNumber: '1009362011', orderCreatedDate: '2022-01-27T23:16:27.000Z', orderModifiedDate: '2022-01-27T23:20:00.000Z', orderActivityType: 'NEWINSTALL', orderStatus: 'IN PROGRESS', orderCommittedDueDate: '2022-02-01T00:00:00.000Z', orderDueDate: '2022-02-01T00:00:00.000Z', accountNumber: 'PPB03315712', cpeShipmentsShipMethod: 'GND', cpeShipmentsTrackingNumber: '1ZX738X70256681223', cpeShipmentsEstimatedDeliveryDate: '2022-02-24T06:00:00.000Z', dispatchDueDate: '2022-02-22 19:00:00', dispatchEstimatedStartTime: '2022-02-20 09:45:00', apptDate: 'August 7', apptStartTime: '9 AM', apptEndTime: '8 PM', dispatchEstimatedFinishTime: '2022-02-22 09:41:00', techInstall: false, hasHSI: false, accountBillingSource: 'PPP' } }
                    // getprofiledataforhome.data.earlyAccessProductOrderResponse = earlyproductgetprofiledatadummy
                    // *********************end of stubbing ******************
                    // }
                }
            } catch (error) {
                if (!this.state?.isDataFlowChecked) {
                    commit('setWkLocation', 'store_index')
                    commit('setWorkNm', 'getprofiledata')
                    commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, but there was an exception caught while getting profile data. Username is' + this.state.username)
                    commit('setWrkEffort', 0)
                    this.dispatch('trackUiIssue')
                    commit('setIsDataFlowChecked', true)
                }
                console.log('Error response ' + error)
                commit('setprofileDataHome', 'failure')
                commit('setisBrightspeedCustomer', false)
                this.state.isBrightspeedCustomer = false
                window.dataLayer.push({
                    event: 'my_ctl_error',
                    flow: {
                        name: 'my ctl: home'
                    },
                    errorName: 'ctl|ma|account|home_error|account_profile_data_error',
                    noninteraction: false
                })
                // alert('Something went wrong')
            }
        },
        async getHsiInfo ({ commit }) {
            console.log('--- Entered getHsiInfo ---')
            console.log('profileId = ' + this.state.profileID)
            console.log('BlueMarble = ' + this.state.isBlueMarble)
            console.log('AccountNumber = ' + this.state.accountNumber)
            commit('setWkLocation', 'store_index')
            commit('setWorkNm', 'getHsiInfo')
            commit('setWrkEffort', 0)
            const params = {
                accountNumber: this.state.accountNumber,
                blueMarbleIndicator: this.state.isBlueMarble,
                username: this.state.profileID
            }

            console.log('--- getHsiInfo params =' + JSON.stringify(params))
            try {
                const retAccountSvcAndOffrs = await axios.post(
                    process.env.VUE_APP_Auth_BASE_URL + '/Orch/dssh/services/myServices', params)
                console.log('--- getHsiInfo - retAccountSvcAndOffrs =' + JSON.stringify(retAccountSvcAndOffrs))
                console.log('--- getHsiInfo - retAccountSvcAndOffrs2 =' + retAccountSvcAndOffrs)

                if (retAccountSvcAndOffrs?.status !== 200) {
                    if (!this.state?.isDataFlowChecked) {
                        commit('setWkLocation', 'store_index')
                        commit('setWorkNm', 'getHsiInfo')
                        commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, but services were not found. Username is' + this.state.username)
                        commit('setWrkEffort', 0)
                        this.dispatch('trackUiIssue')
                        commit('setIsDataFlowChecked', true)
                    }
                    console.log('--- getHsiInfo bad response ---')
                    commit('isHsiCallSucc', 'failure')
                    commit('setIsHsiOwned', false)
                    commit('setIsSmartNidModem', false)
                    commit('setDownloadSpeed', null)
                    commit('setAccountSvcAndOffrs', 'failure')
                } else { // START myServices success flow
                    console.log('*****Customer successfully logged in, and services found ' + JSON.stringify(params.accountNumber))
                    console.log(' --- myService Response not null')
                    // check for status
                    if (retAccountSvcAndOffrs?.data?.statusInfo?.status?.toUpperCase() === 'FAILURE') {
                        commit('setAccountSvcAndOffrs', 'failure')
                        if (!this.state?.isDataFlowChecked) {
                            commit('setWkLocation', 'store_index')
                            commit('setWorkNm', 'getHsiInfo')
                            commit('setWorkTyp', 'LOGIN STATS Customer has logged in but failed in myservices due to a failure status code Username is' + this.state.username)
                            commit('setWrkEffort', 0)
                            this.dispatch('trackUiIssue')
                            commit('setIsDataFlowChecked', true)
                        }
                    }
                    commit('setIsSmartNidModem', false)
                    // check for BlueMarble vs noBlueMarble Response
                    if (this.state.isBlueMarble) {
                        console.log(' --- Found internet BlueMarble')
                        const startTime = new Date()
                        const retDioProdEligibility = retAccountSvcAndOffrs?.data?.dioProductEligibility
                        if (retDioProdEligibility !== null) {
                            commit('setIsHsiCallSucc', true)
                            commit('setIsHsiOwned', (retDioProdEligibility.hasHsi === true))
                            console.log('*************** BM isOwned : ' + retDioProdEligibility.hasHsi)
                            if (!this.state?.isDataFlowChecked) {
                                commit('setWkLocation', 'store_index')
                                commit('setWorkNm', 'getHsiInfo')
                                commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, and services successfully retrieved (BlueMarble flow). Username is' + this.state.username)
                                commit('setWrkEffort', 0)
                                this.dispatch('trackUiIssue')
                                commit('setIsDataFlowChecked', true)
                            }
                            if (retDioProdEligibility?.smartNidInidicator != null && retDioProdEligibility?.smartNidInidicator.toString().toLowerCase() === 'active') {
                                if (retDioProdEligibility?.modemAccountType != null && (retDioProdEligibility?.modemAccountType.toString().toLowerCase() === 'lease' || retDioProdEligibility?.modemAccountType.toString().toLowerCase() === 'purchase' || retDioProdEligibility?.modemAccountType.toString().toLowerCase() === 'byom')) {
                                    if (retDioProdEligibility?.modemClass != null && retDioProdEligibility?.modemClass.toString().toLowerCase() === 'premium wifi') {
                                        console.log('SmartNID modem found')
                                        commit('setIsSmartNidModem', true)
                                        try {
                                            commit('setWorkTyp', 'SmartNID modem found for account ' + this.state.accountNumber)
                                            commit('setWorkNm', 'getHsiInfo myServices check for SmartNid modem')
                                            const params = {
                                                accountNumber: this.state.accountNumber,
                                                emailAddress: this.state.emailAddressForLogging,
                                                page: this.state.wkLocation,
                                                operation: this.state.workNm,
                                                message: this.state.workTyp,
                                                level: this.state.wrkEffort
                                            }
                                            const retrievePostAuthWorkTimeResp = await axios.post(process.env.VUE_APP_Auth_BASE_URL + process.env.VUE_APP_WORK_MEASURING_URL, params)
                                            commit('SET_timedWork', retrievePostAuthWorkTimeResp)
                                        } catch (error) {
                                            console.log('measuredWork error = ' + error)
                                        }
                                    }
                                }
                            }

                            // setting cookies
                            if (retDioProdEligibility?.hasDtv === true) {
                                this.state.ownsDTV = 'Yes'
                                commit('setownsDTV', 'Yes')
                                console.log('*DTV isOwned : ' + retDioProdEligibility.hasDtv)
                            } else if (retDioProdEligibility?.hasDtv === false) {
                                this.state.ownsDTV = 'No'
                                commit('setownsDTV', 'No')
                                console.log('*DTV  not isOwned : ' + retDioProdEligibility.hasDtv)
                            }

                            let downloadInMbps = null
                            let displayDownLoadSpeed = null
                            if (retDioProdEligibility.ownedHsiSpeedInKbps !== null && retDioProdEligibility.ownedHsiSpeedInKbps !== '') {
                                downloadInMbps = (retDioProdEligibility.ownedHsiSpeedInKbps) / 1000
                                if (downloadInMbps >= 1000) {
                                    displayDownLoadSpeed = '1 Gig'
                                } else {
                                    displayDownLoadSpeed = downloadInMbps + ' Mbps'
                                }
                            }

                            commit('setDownloadSpeed', displayDownLoadSpeed)
                            console.log(' BM downloadSpeed : ' + displayDownLoadSpeed)

                            let maxAvailSpeedMbps = null
                            let displayMaxSpeed = null
                            console.log('***** DEBUG incomong maxSpeed = ' + retDioProdEligibility.availableHsiSpeedInKbps)
                            if (retDioProdEligibility.availableHsiSpeedInKbps !== null && retDioProdEligibility.availableHsiSpeedInKbps !== '') {
                                maxAvailSpeedMbps = (retDioProdEligibility.availableHsiSpeedInKbps) / 1000
                                console.log('BM retrieved max speed of ' + maxAvailSpeedMbps + ' Mbps')
                                if (maxAvailSpeedMbps >= 1000) {
                                    displayMaxSpeed = '1 Gig'
                                } else {
                                    displayMaxSpeed = maxAvailSpeedMbps + ' Mbps'
                                }
                            }
                            console.log('BM retrieved max speed of ' + displayMaxSpeed)
                            commit('setMaxSpeedHSIAvailable', displayMaxSpeed)
                            commit('setHsiAvail', retDioProdEligibility.hsiAvailable === true)
                            commit('setBroadbandExhaust', retDioProdEligibility.broadbandExhaust === true)
                            commit('setMaxSpeedHsiTechTypeAvail', 'NA')
                            commit('setAccountSvcAndOffrs', retAccountSvcAndOffrs)
                            commit('setConnectedVoiceAdd', retDioProdEligibility?.ecFlowsAvailable?.CONNECTED_VOICE_ADD)
                            commit('setChangeModem', retDioProdEligibility?.ecFlowsAvailable?.CHANGE_MODEM)
                            const isAddOns = {
                                isDirectvOwned: retDioProdEligibility?.hasDtv === true,
                                isPersonalTechProOwned: retDioProdEligibility?.valueAddedServices?.PERSONAL_TECH_PRO === true,
                                isCyberShieldOwned: retDioProdEligibility?.valueAddedServices?.CYBER_SHIELD === true
                            }
                            // determine if the most recent order can be cancelled
                            /*
                            RULES
                              1) the env var VUE_APP_DISPLAY_CANCEL must be true
                              2) the account must NOT be brightspeed
                              3) must be BlueMarble
                              4) hasPendingOrder must be true
                              5) ponrStatus must be false
                             */

                            const cancelOnToggle = process.env.VUE_APP_DISPLAY_CANCEL
                            if ((cancelOnToggle) && (!this.state.isBrightspeedCustomer)) {
                                if (retDioProdEligibility?.hasPendingOrder === true && retDioProdEligibility?.ponrStatus !== true) {
                                    commit('setIsEligibleForCancel', true)
                                } else {
                                    commit('setIsEligibleForCancel', false)
                                }
                                if (retDioProdEligibility?.ponrStatus === true) {
                                    commit('setisPONR', true)
                                } else {
                                    commit('setisPONR', false)
                                }
                            } else {
                                // NEVER display cancel button when the displayCancel is false nor if the account is BrightSpeed
                                console.log('SKIPPING cancel order logic button because VUE_APP_DISPLAY_CANCEL=' + process.env.VUE_APP_DISPLAY_CANCEL + ' and isBrightspeedCustomer=' + this.state.isBrightspeedCustomer)
                                commit('setIsEligibleForCancel', false)
                            }

                            console.log('index- - BM check for cancel eligibility = ' + this.state.isEligibleForCancel)
                            commit('setAddOns', isAddOns)
                            console.log(' AddOns List : ' + JSON.stringify(this.state.isAddOns))

                            if (retDioProdEligibility.specialConsiderations?.EBBP) {
                                console.log('EBBP checking. ', retDioProdEligibility.specialConsiderations.EBBP)
                                this.state.hasEBBPDiscount = retDioProdEligibility.specialConsiderations.EBBP
                                commit('setHasEBBPDiscount', this.state.hasEBBPDiscount)
                            } else {
                                this.state.hasEBBPDiscount = false
                                commit('setHasEBBPDiscount', this.state.hasEBBPDiscount)
                            }
                            if (retDioProdEligibility.specialConsiderations?.CONNECTED_VOICE) {
                                console.log('EBBP checking. ', retDioProdEligibility.specialConsiderations.CONNECTED_VOICE)
                                this.state.hasConnectedVoice = retDioProdEligibility.specialConsiderations.CONNECTED_VOICE
                            } else {
                                this.state.hasConnectedVoice = false
                            }
                            if (retDioProdEligibility.specialConsiderations?.ACP_DISCOUNT) {
                                console.log('ACP checking. ', retDioProdEligibility.specialConsiderations.ACP_DISCOUNT)
                                this.state.hasACPDiscount = retDioProdEligibility.specialConsiderations.ACP_DISCOUNT
                                commit('setHasACPDiscount', this.state.hasACPDiscount)
                            } else {
                                this.state.hasACPDiscount = false
                                commit('setHasACPDiscount', this.state.hasACPDiscount)
                            }
                            if (retDioProdEligibility.specialConsiderations?.LIFELINE_DISCOUNT) {
                                this.state.hasLifelinediscount = retDioProdEligibility.specialConsiderations.LIFELINE_DISCOUNT
                                commit('sethasLifelinediscount', this.state.hasLifelinediscount)
                            } else {
                                this.state.hasLifelinediscount = false
                                commit('sethasLifelinediscount', this.state.hasLifelinediscount)
                            }
                            if (retDioProdEligibility.specialConsiderations?.SIMPLY_UNLIMITED_PHONE) {
                                console.log('SIMPLY_UNLIMITED_PHONE checking. ', retDioProdEligibility.specialConsiderations.SIMPLY_UNLIMITED_PHONE)
                                this.state.simplyUnlimitedPhone = retDioProdEligibility.specialConsiderations.SIMPLY_UNLIMITED_PHONE
                                commit('setSimplyUnlimitedPhone', this.state.simplyUnlimitedPhone)
                            } else {
                                this.state.simplyUnlimitedPhone = false
                                commit('setSimplyUnlimitedPhone', this.state.simplyUnlimitedPhone)
                            }
                            if (retDioProdEligibility.hasPhone) {
                                commit('setIsPhoneOwned', (retDioProdEligibility.hasPhone === true))
                            } else {
                                commit('setIsPhoneOwned', false)
                            }
                            if (retDioProdEligibility?.specialConsiderations?.VACATION_SUSPEND) {
                                commit('setIsVacationSuspended', true)
                            } else {
                                commit('setIsVacationSuspended', false)
                            }
                            if (retDioProdEligibility?.canVacationRestore) {
                                commit('setCanVacationRestored', true)
                            } else {
                                commit('setCanVacationRestored', false)
                            }
                            if (retDioProdEligibility?.canVacationSuspend) {
                                commit('setCanVacationSuspend', true)
                            } else {
                                commit('setCanVacationSuspend', false)
                            }
                            console.log(' phone isOwned : ' + this.state.isPhoneOwned)
                            console.log('***** downloadSpeed = ' + this.state.downloadSpeed)
                            console.log('***** maxSpeed = ' + this.state.maxSpeedHSIAvailable)
                            let maxSpeedValBM = 0
                            let curSpeedValBM = 0
                            if ((this.state.isHsiOwned) &&
                                (this.state.maxSpeedHSIAvailable !== null) &&
                                (this.state.maxSpeedHSIAvailable !== '')) {
                                maxSpeedValBM = maxAvailSpeedMbps
                                curSpeedValBM = downloadInMbps
                                if (parseInt(maxSpeedValBM, 10) > parseInt(curSpeedValBM, 10)) {
                                    // Rules
                                    // all BM SMB/RES go to Link
                                    // all the rest go to chat
                                    // if (this.state.customerType === 'SMB') { ----commented to allow smb users to show link
                                    //   // send customer to chat if they own HSI and SMB
                                    //   console.log('***** selected CHAT 1')
                                    //   commit('setOfferHsiInd', 'chat')
                                    // } else {
                                    if (this.state.isBlueMarble) {
                                        console.log('***** selected LINK')
                                        commit('setOfferHsiInd', 'link')
                                    } else {
                                        // send customer to chat if are not BlueMarble
                                        console.log('***** selected CHAT 2')
                                        commit('setOfferHsiInd', 'chat')
                                    }
                                    // }
                                    // setting cookie
                                    this.state.upgradeEligibleHSI = 'Yes'
                                    commit('setupgradeEligibleHSI', 'Yes')
                                } else {
                                    //  Max not Greater than current download do not display hsiOffer
                                    console.log('***** selected NONE')
                                    commit('setOfferHsiInd', 'none')
                                    // setting cookie
                                    this.state.upgradeEligibleHSI = 'No'
                                    commit('setupgradeEligibleHSI', 'No')
                                }
                            } else {
                                // No HSI or unknown maxSpeed do not display hsiOffer
                                console.log('***** selected NONE')
                                commit('setOfferHsiInd', 'none')
                            }
                        } else {
                            console.log('BlueMarble returned empty dioproductEligibility')
                            commit('setisPONR', false)
                        }
                        const endTime = new Date()
                        console.log('Index.js duration2 is {}', endTime - startTime)
                        // END BlueMarbleMapping
                    } else if (retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.internet) {
                        // /////////////////////////////////////////////////////////////////////////
                        // start non BlueMarble logic
                        console.log(' --- Found internet nonBM')
                        const saoInternet = retAccountSvcAndOffrs.data.servicesAndOffersResponse.internet
                        console.log(' --- saoInternet =' + saoInternet)
                        commit('setIsHsiCallSucc', true)
                        commit('setIsSmartNidModem', false)
                        commit('setIsHsiOwned', (saoInternet.isOwned === 'true'))
                        commit('setIsEligibleForCancel', false)
                        commit('setDownloadSpeed', saoInternet.downloadSpeed)
                        commit('setMaxSpeedHsiTechTypeAvail', saoInternet.maxSpeedHSITechTypeAvailable)
                        commit('setHsiAvail', saoInternet.hsiAvailableIndicator)
                        commit('setBroadbandExhaust', saoInternet.broadBandExhaustIndicator)
                        commit('setMaxSpeedHSIAvailable', saoInternet.maxSpeedHSIAvailable)
                        console.log(' SAO isOwned : ' + saoInternet.isOwned)
                        console.log(' SAO downloadSpeed : ' + saoInternet.downloadSpeed)
                        commit('setAccountSvcAndOffrs', retAccountSvcAndOffrs)
                        if (!this.state?.isDataFlowChecked) {
                            commit('setWkLocation', 'store_index')
                            commit('setWorkNm', 'getHsiInfo')
                            commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, and services successfully retrieved (non-BlueMarble flow). Username is' + this.state.username)
                            commit('setWrkEffort', 0)
                            this.dispatch('trackUiIssue')
                            commit('setIsDataFlowChecked', true)
                            console.log('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, and services successfully retrieved (non-BlueMarble flow). Username is' + this.state.username)
                        }
                        if (retAccountSvcAndOffrs?.data?.specialConsiderations?.EBBP) {
                            console.log('EBBP checking. ', retAccountSvcAndOffrs.data.specialConsiderations.EBBP)
                            this.state.hasEBBPDiscount = retAccountSvcAndOffrs.data.specialConsiderations.EBBP
                            commit('setHasEBBPDiscount', this.state.hasEBBPDiscount)
                        } else {
                            this.state.hasEBBPDiscount = false
                            commit('setHasEBBPDiscount', this.state.hasEBBPDiscount)
                        }
                        if (retAccountSvcAndOffrs?.data?.specialConsiderations?.CONNECTED_VOICE) {
                            console.log('EBBP checking. ', retAccountSvcAndOffrs.data.specialConsiderations.CONNECTED_VOICE)
                            this.state.hasConnectedVoice = retAccountSvcAndOffrs.data.specialConsiderations.CONNECTED_VOICE
                        } else {
                            this.state.hasConnectedVoice = false
                        }
                        if (retAccountSvcAndOffrs?.data?.specialConsiderations?.ACP_DISCOUNT) {
                            console.log('ACP checking. ', retAccountSvcAndOffrs.data.specialConsiderations.ACP_DISCOUNT)
                            this.state.hasACPDiscount = retAccountSvcAndOffrs.data.specialConsiderations.ACP_DISCOUNT
                            commit('setHasACPDiscount', this.state.hasACPDiscount)
                        } else {
                            this.state.hasACPDiscount = false
                            commit('setHasACPDiscount', this.state.hasACPDiscount)
                        }
                        if (retAccountSvcAndOffrs?.data?.specialConsiderations?.LIFELINE_DISCOUNT) {
                            this.state.hasLifelinediscount = retAccountSvcAndOffrs.data.specialConsiderations.LIFELINE_DISCOUNT
                            commit('sethasLifelinediscount', this.state.hasLifelinediscount)
                        } else {
                            this.state.hasLifelinediscount = false
                            commit('sethasLifelinediscount', this.state.hasLifelinediscount)
                        }
                        if (retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.phone) {
                            commit('setIsPhoneOwned', (retAccountSvcAndOffrs.data.servicesAndOffersResponse.phone.isOwned === 'true'))
                            console.log(' phone isOwned : ' + this.state.isPhoneOwned)
                        }
                        const isAddOns = {
                            isDirectvOwned: retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.directv === 'true',
                            isPersonalTechProOwned: retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.addOnPersonalTechPro === 'true',
                            isCyberShieldOwned: retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.addOnCyberShield === 'true'
                        }
                        commit('setAddOns', isAddOns)
                        console.log(' AddOns List : ' + JSON.stringify(this.state.isAddOns))

                        // setting canShopIndicator, ownsDTV  for cookies
                        if (retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.canShopIndicator === true) {
                            this.state.ableToShopOnline = 'Yes'
                            commit('setableToShopOnline', 'Yes')
                        } else if (retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.canShopIndicator === false) {
                            this.state.ableToShopOnline = 'No'
                            commit('setableToShopOnline', 'No')
                        }
                        if (retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.directv?.isOwned === true) {
                            this.state.ownsDTV = 'Yes'
                            commit('setownsDTV', 'Yes')
                            console.log('*DTV   isOwned : ' + retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.directv?.isOwned)
                        } else if (retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.directv?.isOwned === false) {
                            this.state.ownsDTV = 'No'
                            commit('setownsDTV', 'No')
                            console.log('*DTV  not isOwned : ' + retAccountSvcAndOffrs?.data?.servicesAndOffersResponse?.directv?.isOwned)
                        }
                        console.log('***** downloadSpeed = ' + this.state.downloadSpeed)
                        console.log('***** maxSpeed = ' + this.state.maxSpeedHSIAvailable)
                        let maxSpeedVal = 0
                        let maxSpeedType = ''
                        let curSpeedVal = 0
                        let curSpeedType = ''
                        if ((this.state.isHsiOwned) &&
                            (this.state.maxSpeedHSIAvailable !== null) &&
                            (this.state.maxSpeedHSIAvailable !== '')) {
                            const maxSpeedArray = this.state.maxSpeedHSIAvailable.split(' ')
                            if (maxSpeedArray.length > 0) {
                                maxSpeedVal = maxSpeedArray[0]
                            }
                            if (maxSpeedArray.length > 1) {
                                maxSpeedType = maxSpeedArray[1]
                            }
                            if (maxSpeedType.toUpperCase() === 'GIG') {
                                maxSpeedVal = maxSpeedVal * 1000
                            }

                            if ((this.state.downloadSpeed !== null) && (this.state.downloadSpeed !== '')) {
                                const curSpeedArray = this.state.downloadSpeed.split(' ')
                                if (curSpeedArray.length > 0) {
                                    curSpeedVal = curSpeedArray[0]
                                }
                                if (curSpeedArray.length > 1) {
                                    curSpeedType = curSpeedArray[1]
                                }
                                if (curSpeedType.toUpperCase() === 'GIG') {
                                    curSpeedVal = curSpeedVal * 1000
                                }
                            }

                            console.log('***** convertedMaxSpeed = ' + maxSpeedVal)
                            console.log('***** convertedMaxType = ' + maxSpeedType)
                            console.log('***** convertedCurSpeed = ' + curSpeedVal)
                            console.log('***** convertedCurType = ' + curSpeedType)
                            if (parseInt(maxSpeedVal, 10) > parseInt(curSpeedVal, 10)) {
                                // Rules
                                // all BM SMB/RES go to Link
                                // all the rest go to chat
                                // if (this.state.customerType === 'SMB') { ----commented to allow smb users to show link
                                //   // send customer to chat if they own HSI and SMB
                                //   console.log('***** selected CHAT 1')
                                //   commit('setOfferHsiInd', 'chat')
                                // } else {
                                if (this.state.isBlueMarble) {
                                    console.log('***** selected LINK')
                                    commit('setOfferHsiInd', 'link')
                                } else {
                                    // send customer to chat if are not BlueMarble
                                    console.log('***** selected CHAT 2')
                                    commit('setOfferHsiInd', 'chat')
                                }
                                // }

                                // Cookies setup
                                this.state.upgradeEligibleHSI = 'Yes'
                                commit('setupgradeEligibleHSI', 'Yes')
                            } else {
                                //  Max not Greater than current download do not display hsiOffer
                                console.log('***** selected NONE')
                                commit('setOfferHsiInd', 'none')
                                // Cookies setup
                                this.state.upgradeEligibleHSI = 'No'
                                commit('setupgradeEligibleHSI', 'No')
                            }
                        } else {
                            // No HSI or unknown maxSpeed do not display hsiOffer
                            console.log('***** selected NONE')
                            commit('setOfferHsiInd', 'none')
                            commit('setIsSmartNidModem', false)
                        }
                    } else {
                        console.log(' --- NOT finding internet')
                    }// END non BlueMarble logic
                    const enableNBACall = process.env.VUE_APP_ENABLE_NBA_CALL
                    if (enableNBACall === 'true' && !this.state.nbaCallDone) {
                        console.log('Calling NBA service')
                        try {
                            commit('setNBACallDone', true)
                            const nbaResponse = await axios.get(
                                process.env.VUE_APP_Auth_BASE_URL + '/Orch/dho/nba/checkModemOffer?accountNumber=' + this.state.accountNumber)
                            this.state.nbaCallDone = true
                            console.log('NBA service call done, response -> ', nbaResponse)
                            if (nbaResponse.data.statusInfo.status === 'SUCCESS' &&
                                nbaResponse.data.response.eligibility && nbaResponse.data.response.outOfServiceCreditEligible) {
                                commit('setNBAModemReplacement', eligible)
                                commit('setNbaOutOfServiceCreditsOfferStatus', eligible)
                                commit('setNbaOutOfServiceCreditsOfferValue', nbaResponse.data.response.billCreditAmount ?? null)
                            } else if (nbaResponse.data.statusInfo.status === 'SUCCESS' && nbaResponse.data.response.eligibility) {
                                commit('setNBAModemReplacement', eligible)
                                commit('setNbaOutOfServiceCreditsOfferStatus', ineligible)
                            } else if (nbaResponse.data.statusInfo.status === 'SUCCESS' &&
                                nbaResponse.data.response.outOfServiceCreditEligible) {
                                commit('setNBAModemReplacement', ineligible)
                                commit('setNbaOutOfServiceCreditsOfferStatus', eligible)
                                commit('setNbaOutOfServiceCreditsOfferValue', nbaResponse.data.response.billCreditAmount ?? null)
                            } else {
                                commit('setNBAModemReplacement', ineligible)
                                commit('setNbaOutOfServiceCreditsOfferStatus', ineligible)
                            }
                        } catch (error) {
                            console.log('Error while calling NBA eligibility ', error)
                            commit('setNBACallDone', true)
                            commit('setNBAModemReplacement', ineligible)
                        }
                    } else {
                        if (!this.state.nbaCallDone) {
                            console.log('NBA service INELIGIBLE')
                            commit('setNBAModemReplacement', ineligible)
                        }
                    }
                } // END myServices success flow
                commit('setIsHSICallDone', true)
            } catch (e) {
                if (!this.state?.isDataFlowChecked) {
                    commit('setWkLocation', 'store_index')
                    commit('setWorkNm', 'getHsiInfo')
                    commit('setWorkTyp', 'LOGIN STATS Customer has logged in successfully, but services were unable to be retrieved. Username is' + this.state.username)
                    commit('setWrkEffort', 0)
                    this.dispatch('trackUiIssue')
                    commit('setIsDataFlowChecked', true)
                }
                commit('setIsHSICallDone', true)
                console.log('--- getHsiInfo - unexpected exception caught while calling myServices. Error =  ' + e)
                commit('setAccountSvcAndOffrs', 'failure')
            }
            return commit
        },
        async setAccptRejectMdmRplcmt ({ commit }, [choice, offer]) {
            if (this.state.nbaModemReplacement === eligible || this.state.nbaOutOfServiceCreditsOfferStatus === eligible) {
                if (choice == null || choice === '' || !(choice.toString().toLowerCase() === accepted || choice.toString().toLowerCase() === declined)) {
                    commit('setAccptRejectCallSuccessful', false)
                } else {
                    // happy path there is a valid choice and the acct is currently eligible for replacement
                    try {
                        const ENV_ACCT_REJCT_CHANNEL = process.env.VUE_APP_ACCPT_RJCT_CHNNL
                        let inActionVal = null
                        if (choice.toString().toLowerCase() === accepted) {
                            inActionVal = 'Accepted'
                        } else {
                            inActionVal = 'Declined'
                        }
                        const params = {
                            channel: ENV_ACCT_REJCT_CHANNEL,
                            accountNumber: this.state.accountNumber,
                            userResponse: inActionVal,
                            offerName: offer
                        }
                        const captureMdmRplcResp = await axios.post(
                            process.env.VUE_APP_Auth_BASE_URL + '/Orch/dho/nba/captureModemReplacementResponse', params)
                        if (captureMdmRplcResp?.data?.response != null && captureMdmRplcResp?.data?.response?.status === 'OK' && offer === modemOfferName) {
                            commit('setNBACaptureResponse', captureMdmRplcResp?.data)
                            commit('setAccptRejectCallSuccessful', true)
                            console.log('ModemReplacementAcceptedRejectedCall success')
                            if (inActionVal === 'Accepted') {
                                commit('setNBAModemReplacement', 'Accepted')
                                console.log('setNBAModemReplacement Accepted')
                            } else {
                                commit('setNBAModemReplacement', 'Declined')
                                console.log('setNBAModemReplacement Declined')
                            }
                        } else if (captureMdmRplcResp?.data?.response != null && captureMdmRplcResp?.data?.response?.status === 'OK' && offer === serviceCreditOfferName) {
                            commit('setNBACaptureResponse', captureMdmRplcResp?.data)
                            commit('setAccptRejectCallSuccessful', true)
                            console.log('ModemReplacementAcceptedRejectedCall success')
                            if (inActionVal === 'Accepted') {
                                commit('setNbaOutOfServiceCreditsOfferStatus', 'Accepted')
                                console.log('setNbaOutOfServiceCreditsOfferStatus Accepted')
                            } else {
                                commit('setNbaOutOfServiceCreditsOfferStatus', 'Declined')
                                console.log('setNbaOutOfServiceCreditsOfferStatus Declined')
                            }
                        } else {
                            commit('setNBACaptureResponse', captureMdmRplcResp?.data)
                            commit('setAccptRejectCallSuccessful', false)
                            console.log(captureMdmRplcResp)
                        }
                    } catch (error) {
                        commit('setNBACaptureResponse', 'Failure')
                        // error thrown attempting to call Orch
                        commit('setAccptRejectCallSuccessful', false)
                        console.log(error)
                    }
                }
            }
        },

        // expected RequestObj = public class InteractionInfoRequest {
        //     boolean stubbed;  expect false except for limited testing should be driven by env property
        //     String accountNumber;
        //     String orderStatus; "PENDING" "IN PROGRESS" "COMPLETED" "CANCELED"
        //     String orderCreatedDate; sent only for the "PENDING" "IN PROGRESS" orders in YYYY-MM-DD frmt
        //     String orderCompletedOrCancelledDate; used only for the "CANCELED" or "COMPLETED" orders in YYYY-MM-DD frmt
        // }
        async getOrderInteractionInfo ({ commit }, [interactionInfoRequest]) {
            console.log('^^^^^^^^^^^  START getOrderInteractionInfo ^^^^^^^^^^^^^^^')
            try {
                console.log('--- getOrderInteractionInfo - retInteractionInfoRequest =' + JSON.stringify(interactionInfoRequest))
                if (interactionInfoRequest != null) {
                    let ordInteractInputGood = true
                    // start input verification
                    if (interactionInfoRequest.accountNumber != null && interactionInfoRequest.accountNumber !== '') {
                        if (interactionInfoRequest.orderStatus != null &&
                            (interactionInfoRequest.orderStatus.toLowerCase() === 'pending' || interactionInfoRequest.orderStatus.toLowerCase() === 'in progress' ||
                                interactionInfoRequest.orderStatus.toLowerCase() === 'cancelled' || interactionInfoRequest.orderStatus.toLowerCase() === 'canceled' || interactionInfoRequest.orderStatus.toLowerCase() === 'completed')) {
                            if (interactionInfoRequest.orderCreatedDate === null && interactionInfoRequest.orderCompletedOrCancelledDate === null) {
                                console.log('no valid date sent in interactionInfo request')
                                ordInteractInputGood = false
                            } else {
                                if ((interactionInfoRequest.orderStatus.toLowerCase() === 'pending' || interactionInfoRequest.orderStatus.toLowerCase() === 'in progress') && interactionInfoRequest.orderCreatedDate === null) {
                                    console.log('wrong date sent in interactionInfo request')
                                    ordInteractInputGood = false
                                } else {
                                    if ((interactionInfoRequest.orderStatus.toLowerCase() === 'canceled' || interactionInfoRequest.orderStatus.toLowerCase() === 'completed') &&
                                        interactionInfoRequest.orderCompletedOrCancelledDate === null) {
                                        console.log('wrong date sent in interactionInfo request')
                                        ordInteractInputGood = false
                                    }
                                }
                            }
                        } else {
                            console.log('no valid orderStatus sent in interactionInfo request')
                            ordInteractInputGood = false
                        }
                    } else {
                        console.log('no valid accountNumber sent in interactionInfo request')
                        ordInteractInputGood = false
                    }

                    // end input verification
                    if (ordInteractInputGood) {
                        const gotoUrl = process.env.VUE_APP_Auth_BASE_URL + process.env.VUE_APP_GET_ORDER_INTERACTION_INFO
                        const retInteractionInfoResp = await axios.post(gotoUrl, interactionInfoRequest)

                        console.log('--- getOrderInteractionInfo - retInteractionInfoResp =' + JSON.stringify(retInteractionInfoResp))

                        if (retInteractionInfoResp?.data?.statusInfo?.status?.toUpperCase() === 'SUCCESS') {
                            if (retInteractionInfoResp?.data?.techTrackerPresent) {
                                commit('setTechTrackerFound', true)
                                console.log('techTracker set to true')
                            } else {
                                commit('setTechTrackerFound', false)
                                console.log('techTracker set to false')
                            }
                            if (retInteractionInfoResp?.data?.interactions && retInteractionInfoResp?.data?.interactions.length) {
                                console.log('getInteractionInfoResp returned a NON EMPTY list')
                                commit('setFoundSmsMsg', true)
                                commit('setGetOrderInteractionInfo', retInteractionInfoResp?.data?.interactions)
                            } else {
                                console.log('getInteractionInfoResp returned empty list')
                                commit('setFoundSmsMsg', false)
                                commit('setGetOrderInteractionInfo', [])
                            }
                            commit('setGetOrderInteractionInfoCallSuccess', true)
                        } else {
                            console.log('getInteractionInfoResp returned non success response')
                            commit('setGetOrderInteractionInfoCallSuccess', true)
                            commit('setGetOrderInteractionInfo', [])
                            commit('setFoundSmsMsg', false)
                        }
                    } else {
                        console.log('input verification failed')
                        commit('setGetOrderInteractionInfoCallSuccess', false)
                        commit('setGetOrderInteractionInfo', [])
                        commit('setFoundSmsMsg', false)
                    }
                } else {
                    console.log('getInteractionInfoRequest object was empty')
                    commit('setGetOrderInteractionInfoCallSuccess', false)
                    commit('setGetOrderInteractionInfo', [])
                    commit('setFoundSmsMsg', false)
                }
            } catch (error) {
                console.log('getInteractionInfoResp threw an error ' + error)
                // error thrown attempting to call Orch
                commit('setGetOrderInteractionInfoCallSuccess', false)
                commit('setFoundSmsMsg', false)
                commit('setGetOrderInteractionInfo', [])
                console.log(error)
            }
            // debug final new store values
            console.log('!!!!!!!!!!!!!!!!   getOrderInteractionInfoCall - isWheresMyTechKillSwitch = ' + this.state.isWheresMyTechKillSwitch)
            console.log('!!!!!!!!!!!!!!!!   getOrderInteractionInfoCall - getOrderInteractionInfoCallSuccess = ' + this.state.getOrderInteractionInfoCallSuccess)
            console.log('!!!!!!!!!!!!!!!!   getOrderInteractionInfoCall - getTechTrackerFound = ' + this.state.getTechTrackerFound)
            console.log('!!!!!!!!!!!!!!!!   getOrderInteractionInfoCall - foundSmsMsg = ' + this.state.foundSmsMsg)
            console.log('!!!!!!!!!!!!!!!!   getOrderInteractionInfoCall - getOrderInteractionInfo = ' + this.state.getOrderInteractionInfo)
        },

        // *******************************************************************************************************************
        // new method start ***************************************************************************************************
        // this call starts with the same call as the getOrderInteractionInfoCall above and will use the same interactionInfoRequest input
        // the differences is that this call will be only for PENDING orders so the interactionInfoRequest.orderStatus will be optional
        // and we will set the value to PENDING. Also, since this is a pending order the interactionInfoRequest.orderCreatedDate will be required
        // the orderCompletedOrCancelledDate will not be used in this method at this time
        // The interactionInfoRequest.accountNumber also will still be required
        async clickTechTracker ({ commit }, [interactionInfoRequest]) {
            console.log('^^^^^^^^^^^  START clickTechTracker ^^^^^^^^^^^^^^^')
            try {
                console.log('--- clickTechTracker - retInteractionInfoResp =' + JSON.stringify(interactionInfoRequest))
                if (interactionInfoRequest != null) {
                    let clickTechTrackerInputGood = true
                    // start input verification
                    if (interactionInfoRequest.accountNumber != null && interactionInfoRequest.accountNumber !== '') {
                        if (interactionInfoRequest.orderCreatedDate != null && interactionInfoRequest.orderCreatedDate !== '') {
                            interactionInfoRequest.orderStatus = 'pending'
                        } else {
                            console.log('no valid accountNumber sent in clickTechTracker interactionInfo request')
                            clickTechTrackerInputGood = false
                        }
                    } else {
                        console.log('no valid orderCreatedDate sent in clickTechTracker interactionInfo request')
                        clickTechTrackerInputGood = false
                    }
                    // end input verification
                    if (clickTechTrackerInputGood) {
                        const gotoUrl = process.env.VUE_APP_Auth_BASE_URL + process.env.VUE_APP_GET_ORDER_INTERACTION_INFO
                        const retInteractionInfoResp = await axios.post(gotoUrl, interactionInfoRequest)

                        console.log('--- clickTechTracker - retInteractionInfoResp =' + JSON.stringify(retInteractionInfoResp))

                        if (retInteractionInfoResp?.data?.statusInfo?.status?.toUpperCase() === 'SUCCESS') {
                            if (retInteractionInfoResp?.data?.techTrackerPresent) {
                                commit('setTech_Tracker_failed', false)
                                console.log('clickTechTracker techTracker set to true redirecting')
                                console.log('tech BaseURL = ' + process.env.VUE_APP_Auth_BASE_URL)
                                console.log('tech path = ' + process.env.VUE_APP_JUMP_TO_TECH_TRACKER)
                                // const trackerurl = process.env.VUE_APP_Auth_BASE_URL + process.env.VUE_APP_JUMP_TO_TECH_TRACKER + interactionInfoRequest.accountNumber
                                const trackerurl = process.env.VUE_APP_Auth_BASE_URL + '/Orch/dssh/redirectEntry/jumpOutTechTracker?accountNumber=' + interactionInfoRequest.accountNumber
                                console.log('tech url = ' + trackerurl)
                                window.open(trackerurl, '_blank')
                            } else {
                                commit('setTech_Tracker_failed', true)
                                console.log('clickTechTracker techTracker set to false')
                            }
                            commit('setClickTechTrackerCallSuccess', true)
                        } else {
                            console.log('clickTechTracker getInteractionInfoResp returned non success response')
                            commit('setClickTechTrackerCallSuccess', false)
                            commit('setTech_Tracker_failed', true)
                        }
                    } else {
                        console.log('clickTechTracker input verification failed')
                        commit('setClickTechTrackerCallSuccess', false)
                        commit('setTech_Tracker_failed', true)
                    }
                } else {
                    console.log('clickTechTracker getInteractionInfoRequest object was empty')
                    commit('setClickTechTrackerCallSuccess', false)
                    commit('setTech_Tracker_failed', true)
                }
            } catch (error) {
                console.log('clickTechTracker getInteractionInfoResp threw an error ' + error)
                // error thrown attempting to call Orch
                commit('setClickTechTrackerCallSuccess', false)
                commit('setTech_Tracker_failed', true)
                console.log('clickTechTracker error thrown =' + error)
            }
        },

        async getEquipmentDetails ({ commit }) {
            try {
                const data = {
                    wtn: this.state.profiledata?.data?.wtn,
                    accountNumber: this.state.profiledata?.data?.currentlyManagedAccount,
                    isSmartNID: this.state?.isSmartNidModem
                }
                commit('setIsNetWorkServiceCallDoneOnce', true)
                if (data.wtn && this.state?.isHsiOwned && data.accountNumber) {
                    const getModemInfo = await axios.post(process.env.VUE_APP_Auth_BASE_URL + '/Orch/dssh/acs/getNetworkServicesDetails', data)
                    console.log('Modem info ', getModemInfo)
                    if (getModemInfo?.data) {
                        commit('setnetworkResponse', getModemInfo)
                        console.log(' networkResponse : ' + JSON.stringify(this.state.networkResponse))
                        commit('setWkLocation', 'store_index')
                        commit('setWorkNm', 'getModemInfo success')
                        console.log('getEquipmentDetails 1 logging workTyp  with values =' + getModemInfo?.data)
                        commit('setWorkTyp', getModemInfo?.data)
                        commit('setWrkEffort', 0)
                        const modemInfo = {
                            manufacturer: getModemInfo?.data?.manufacturer,
                            modelName: getModemInfo?.data?.modelName,
                            isConnectionStatus: getModemInfo?.data?.connectionStatus === true,
                            macAddress: getModemInfo?.data?.macAddress,
                            istatusMessage: getModemInfo?.data?.manufacturer && getModemInfo?.data?.modelName,
                            serialNumber: getModemInfo?.data?.serialNumber,
                            isAssiaEnabled: getModemInfo?.data?.assiaEnabled
                        }
                        commit('setIsAssiaEnabled', modemInfo.isAssiaEnabled)
                        console.log('Network Service health status ', getModemInfo?.data?.connectionStatus)
                        if (getModemInfo?.data?.connectionStatus) {
                            commit('setIsNetworkConnected', 'true')
                        } else {
                            commit('setIsNetworkConnected', 'false')
                        }
                        commit('setmodemInfo', modemInfo)
                        console.log(' modemInfo List : ' + JSON.stringify(this.state.modemInfo))
                        commit('setIsgetServiceDetailsSuccess', true)
                        if (modemInfo.isAssiaEnabled) {
                            this.dispatch('getHistoricalSpeeds')
                        }
                        if (this.state.profiledata?.data?.accountLifeCycle === 'Active' && getModemInfo?.data?.byom === true) {
                            this.state.isBYOM = true
                            commit('setisBYOM', this.state.isBYOM)
                            console.log('BYOM IS TRUE FROM NETWORK', this.state.isBYOM)
                        }
                        if (this.state.profiledata?.data?.accountLifeCycle === 'Active' && getModemInfo?.data?.thirdPartyModem) {
                            commit('setIsThirdPartyModem', getModemInfo?.data?.thirdPartyModem)
                        }
                        this.dispatch('trackUiIssue')
                    } else {
                        commit('setWkLocation', 'store_index')
                        commit('setWorkNm', 'getModemInfo failure')
                        console.log('getEquipmentDetails 2 logging workTyp  with values =' + getModemInfo?.data)
                        commit('setWorkTyp', getModemInfo?.data)
                        commit('setWrkEffort', 0)
                    }
                    console.log('Testing the equipement details', this.state.manufacturer, this.state.modelName)
                    this.dispatch('trackUiIssue')
                }
            } catch (error) {
                commit('setIsgetServiceDetailsSuccess', false)
                console.log(error)
                commit('setWkLocation', 'store_index')
                commit('setWorkNm', 'getModemInfo error')
                console.log('getEquipmentDetails 3 logging workTyp  with values =' + error)
                commit('setWorkTyp', error)
                commit('setWrkEffort', 0)
                this.dispatch('trackUiIssue')
            }
        },
        async getHistoricalSpeeds ({ commit }) {
            try {
                const data = {
                    wtn: this.state.profiledata?.data?.wtn,
                    accountNumber: this.state.profiledata?.data?.currentlyManagedAccount,
                    isSmartNID: this.state?.isSmartNidModem,
                    isAssiaEnabled: this.state?.isAssiaEnabled,
                    historicalSpeeds: this.state?.historicalSpeeds
                }
                console.log('getHistoricalSpeeds data ', data)
                if (data.wtn && data.accountNumber && data.isAssiaEnabled) {
                    const getHistoricalSpeeds = await axios.get(process.env.VUE_APP_Auth_BASE_URL + '/Orch/dssh/assia/getHistoricalSpeeds?serialNumber=' + this.state?.modemInfo?.serialNumber, data)
                    console.log('getHistoricalSpeeds ', getHistoricalSpeeds?.data)
                    if (getHistoricalSpeeds?.data?.statusInfo?.status?.toUpperCase() === 'SUCCESS') {
                        commit('setHistoricalSpeeds', getHistoricalSpeeds?.data)
                        console.log('getHistoricalSpeeds : ' + JSON.stringify(getHistoricalSpeeds?.data?.sevenDaysHistoricalSpeed))
                    } else {
                        console.log('CANNOT GET HISTORICAL SPEEDS BECAUSE THERE IS NO DATA')
                        this.dispatch('trackUiIssue')
                    }
                }
            } catch (error) {
                console.log(error)
                this.dispatch('trackUiIssue')
            }
        }
    },
    modules: {
    }
})
