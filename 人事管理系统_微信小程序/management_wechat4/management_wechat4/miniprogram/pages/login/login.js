// pages/login/login.js
Page({
  /**
  * 页面的初始数据
  */
  data: {
    disabled:true,
    btnstate:"default",
    account:"",
    password:"",
    flag:""
  },
  accountInput:function(e){
    var content = e.detail.value;
    if(content!=''){
      this.setData({disabled:false,btnstate:"primary",account:content});
    }else{
      this.setData({disabled:true,btnstate:"default"});
    }
  },
  pwdBlur:function(e){
    var password= e.detail.value;
    this.setData({password:password});
  },
  login:function(){
    //console.log(this.data.account)
    //console.log(this.data.password)
    wx.request({
      url: 'http://localhost:8080/admin/login',
      method: 'POST',
      header: {'content-type':'application/x-www-form-urlencoded'},
      data:{
        name:this.data.account,
        password:this.data.password
      },
      success:function(res){
        if(res.data == 1){
          wx.switchTab({
            url: '../enter/enter' ,
          })
        }
        else{
          wx.showToast({
            title: '账号或密码错误',
            icon: 'none',
            duration: 2000
          })
        }
        
      },
      fail:function(res){
        wx.showToast({
          title: '系统错误，请稍后重试',
          icon: 'none',
          duration: 2000
        })
      }
    })
  },
})
