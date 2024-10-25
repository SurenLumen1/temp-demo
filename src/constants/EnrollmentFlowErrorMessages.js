const data = [
  {
    id: 'FAIL_ZIP_MATCH',
    message: '<div>We didn\'t find a match for the values you entered. Please try again.</div>'
  },
  {
    id: 'EMPTY_DVAR_RESPONSE',
    message: '<div>An error has occurred. Please try again later.</div>'
  },
  {
    id: 'EMPTY_DVAR_ACCOUNT',
    message: `<div>Sorry - we didn't find a match for the values you entered. Please try again. <div class="link"><a href=${process.env.VUE_APP_ERROR_EMPTY_DVAR_ACCOUNT} target="_blank">Would you like to have your account number emailed to you?</a></div></div>`
  },
  {
    id: 'BLOCKED_ENSEMBLE_ACCOUNT',
    message: '<div>Your account has been blocked for online access. If you believe this is an error, please <a href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})" class="link">chat with us.</a></div>'
  },
  {
    id: 'ENSEMBLE_SPECIAL_TYPE',
    message: '<div>The account you provided cannot be registered and managed through My CenturyLink at this time due to the account type. If you have questions, please <a class="link" href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})">chat with us.</a></div>'
  },
  {
    id: 'ACCOUNT_TYPE_EMPTY',
    message: '<div>We are not able to determine the required information needed for registering your account at this time. please try again later.</div>'
  },
  {
    id: 'ACCOUNT_BLOCKED',
    message: '<div>The account you provided cannot be registered and managed through My CenturyLink at this time due to the account status. If you have questions, please <a class="link" href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})">chat with us.</a></div>'
  },
  {
    id: 'ACCOUNT_BUSINESS_NON_BM_ENSEMBLE',
    message: `<div>The account you have provided is a business account that is not able to be managed through My CenturyLink. Please <a class="link" target="_blank" href=${process.env.VUE_APP_ERROR_ACCOUNT_BUSINESS_NON_BM_ENSEMBLE}>go here</a> to manage your business account online.</div>`
  },
  // {
  //   id: 'INVALID_AUTHORIZATION_CODE',
  //   message: `<div>The security code you provided doesn't match our records. Need to retrieve your security code? <a href="${process.env.VUE_APP_ERROR_AUTH_CODE}/accountNo=${store.getters.enrollmentAccNumber}" class='link' target="_blank">Here's how.</div>`
  // },
  {
    id: 'ERROR_CREATING_PROFILE',
    message: '<div>There was an error encountered while creating the profile for the account. Please try again later</div>'
  },
  {
    id: 'ERROR_ADDING_ACCOUNT_TO_PROFILE',
    message: '<div>An error was encountered adding the account to the newly created profile</div>'
  },
  {
    id: 'USER_EXISTS_ON_PROFILE',
    message: '<div>That user name is already in use. Please use a different user name</div>'
  },
  {
    id: 'NO_REGISTRATION_ENTITY',
    message: '<div>An error has occurred. Please try again later.</div>'
  },
  {
    id: 'ACCOUNT_IS_EMBARGO',
    message: '<div>Your account is currently unavailable. This planned maintenance period may take up to 6 hours.</div>'
  },
  {
    id: 'ACCOUNT_CANT_REGISTER_BUSINESS',
    message: `<div>The account you have provided is a business account that is not able to be managed through My CenturyLink. Please <a class="link" href=${process.env.VUE_APP_ERROR_ACCOUNT_BUSINESS_NON_BM_ENSEMBLE} target="_blank">go here</a> to manage your business account online.</div>`
  },
  {
    id: 'ACCOUNT_ALREADY_REGISTERED',
    message: `<div>The account number you entered is already registered. <div><a class="link" href=${process.env.VUE_APP_ERROR_FORGOT_USERNAME} target="_blank">Forgot username?</a></div></div>`
  },
  {
    id: 'ACCOUNT_NOT_SHELL_PENDING',
    message: '<div>The account you provided cannot be registered and managed through My CenturyLink at this time due to the account status. If you have questions, please <a href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})" class="link">chat with us.</a></div>'
  },
  {
    id: 'ACCOUNT_CPNI_NO_AUTH',
    message: '<div>There is an issue with your account. Please <a href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})" class="link">chat with us</a></div>'
  },
  {
    id: 'ACCOUNT_EMPTY_CENTURYLINK_ID',
    message: '<div></div>'
  },
  {
    id: 'ACCOUNT_EMPTY_BILLING_SYSTEM',
    message: '<div>An error has occurred. Please try again later.</div>'
  },
  {
    id: 'DVAR_ERROR',
    message: '<div>An error has occurred. Please try again later.</div>'
  },
  {
    id: 'ACCOUNT_NOT_REGISTERABLE',
    message: '<div>An error has occurred. Please try again later.</div>'
  },
  {
    id: 'ACCOUNT_TYPE_O',
    message: '<div>The account you provided cannot be registered and managed through My CenturyLink at this time due to the account type. If you have questions, please <a href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})" class="link">chat with us.</a></div>'
  },
  {
    id: 'SHELL_PROFILE_EMAIL_NOT_SENT',
    message: '<div>An error has occurred. Please try again later.</div>'
  },
  {
    id: 'EARLY_LIFE_ACCOUNT',
    message: '<div>Please check your email as you should have received an email with details on how to complete the registration for the account you have entered. If you have not received the email please <a href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service``,buttonId:`Watson_24_7_Chat_Bot``}) class="link">chat with us</a></div>'
  },
  {
    id: 'ACCOUNT_STATUS_FINAL',
    message: '<div>The account you provided cannot be registered and managed through My CenturyLink at this time due to its status. If you have questions, Please <a class="link" href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})"> contact us.</a></div>'
  },
  {
    id: 'ERROR_ADD_ACCOUNT_TO_PROFILE',
    message: '<div>An error has occurred. Please try again later.</div>'
  }
  // {
  //   id: 'ACCOUNT_ALREADY_REGISTERED',
  //   message: `<div>The account number you entered is already registered. Here are some options:<div><li>If you entered the wrong number, try again.</li><li>Or if it's been a while since you last signed in, we can <a class="link" href=${process.env.VUE_APP_ERROR_FORGOT_USERNAME} target="_blank"> send you an email with your user name.</a></li></div>` + '<p> if you are stuck, <a href="javascript:startChat({skillName:`Watson_24_7_Embedded_Service`,buttonId:`Watson_24_7_Chat_Bot`})" class="link">chat with us</a>so we can help.</p></div>'
  // }
  // {
  //   id: 'INVALID_AUTHORIZATION_CODE',
  //   message: `<div>The security code you provided doesn't match our records. Need to retrieve your security code? <a href="${process.env.VUE_APP_ERROR_AUTH_CODE}" class='link' target="_blank">Here's how.</div>`
  // }
]
export default data
