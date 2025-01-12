// pages/search/search.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    employeeId: '',// 员工编号
    employeeName: '', // 姓名
    gender: '', // 性别
    departmentId: '', // 部门号
    positionId: '', // 岗位号
    phone: '', // 联系电话
    employee: {}, // 用于保存员工信息
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const employee = JSON.parse(options.employee); // 获取传递过来的岗位信息
    this.setData({
      employee: employee,
    });
  },
  // 返回原界面
  back: function() {
    wx.navigateBack({
      delta: 1, // 返回页面数，这里假设是返回到上一个页面
    });
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