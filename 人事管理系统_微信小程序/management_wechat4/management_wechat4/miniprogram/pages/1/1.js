// pages/1/1.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {

  },
  userNameInputAction: function (options) {
    //获取输入框输入的内容
    let value = options.detail.value;
    console.log("输入框输入的内容是 " + value)
  },
  submitForm: function(e) {  
    console.log('表单提交:', e.detail.value);  
    // 这里可以处理表单数据，如发送到服务器等  
  }  ,
  // ... 其他页面逻辑  
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad() {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})