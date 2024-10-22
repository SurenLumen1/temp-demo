<template>
  <div  class="text-center error-rectangle veryLightGreyBack mobileLayout">
    <h1 class="sorryTitle blackRussian title1">We're sorry</h1>
    <h3 class="accountInfo mar-t-16">We're unable to show your account info.</h3>
    <p class="tryAgain mar-t-16">Please try again later.</p>
    <div class="mar-t-36">
      <span class="alreadyTried black mar-r-20 mar-r-10">Already tried again?</span>
      <a class="chatUs cobolt" href="javascript:startChat({skillName:'Watson_24_7_Embedded_Service',buttonId:'Watson_24_7_Chat_Bot'})" @click="gtmtrackinfo()">Chat With Us</a>
    </div>
    <img class="layer" alt="image of 3 people sharing the internet" src="../assets/images/Layer2.png"/>
  </div>
</template>
<script>
export default {
  name: 'Error',
  mounted () {
    this.$gtm.trackView('<account>', '<ctl|ma|account|home_error>')
    window.dataLayer.push({
      event: 'my_ctl_error',
      page: {
        pageName: 'ctl|ma|account|home_error'
      },
      flow: {
        name: 'my ctl: home'
      },
      errorName: 'ctl|ma|account|home_error',
      noninteraction: false
    })
  },
  methods: {
    gtmtrackinfo () {
      window.dataLayer.push({
        event: 'my_ctl_contact_support',
        flow: {
          name: 'my ctl: home'
        },
        buttonName: 'Chat With Us',
        noninteraction: false
      })
    }
  },
  beforeUnmount () {
    window.dataLayer = window.dataLayer || []
    window.dataLayer.push({
      errorName: ''
    })
  }
}
</script>
<style scoped>
.error-rectangle {
  padding: 65px 256px 109px 258px;
}
.errormsginfo{
  letter-spacing: 0.24px;
  font-size: 24px;
  font-weight: normal;
  font-family: MaisonNeue-Light,sans-serif;
  line-height: 1.5;
}
.sorryTitle{
  font-size: 48px;
  text-align: center;
  letter-spacing: 0px;
  opacity: 1;
  font-family: MaisonNeue-Medium, sans-serif;
  line-height: 57px;
}
.accountInfo{
  font-size: 24px;
  font-family: MaisonNeue-Medium, sans-serif;
  letter-spacing: 0.24px;
  line-height: 28px;
}
.tryAgain{
  font-size:16px;
  font-family: MaisonNeue-Medium, sans-serif;
  line-height: 19px;
}
.mar-t-16{
  margin-top: 16px;
}
.mar-t-36{
  margin-top: 36px;
}
.mar-r-20{
  margin-right:20px
}
.alreadyTried{
  font-size: 16px;
  letter-spacing: 0.16px;
  line-height:19px;
  font-family: MaisonNeue-Light, sans-serif;
}
.chatUs{
  font-size: 14px;
  letter-spacing: 0px;
  padding:4px;
  line-height: 36px;
}
.layer{
  max-width: 240px;
  height:250px;
  margin-left: auto;
  margin-right: auto;
  margin-top: 65px;
}
@media (max-width: 768px){
  .title1 {
    font-size: 36px;
  }
  .mobileLayout{
    padding: 40px 37px;
  }
}
@media (max-width: 340px){
  .mar-r-10{
    margin-right: 10px;
  }

}
</style>
