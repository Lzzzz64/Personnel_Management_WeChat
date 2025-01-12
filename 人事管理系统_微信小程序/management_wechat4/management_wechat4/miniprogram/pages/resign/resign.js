// pages/resign/resign.ts
Page({

  /**
   * 页面的初始数据
   */
  data: {
    employee: {}, // 用于保存员工信息
    dimissionInformation:{},
    dimissionDate: '',
    dimissionType: '', //离职类型 
    dimissionGo: '', // 离职去向
    note: '',//备注
    localDateTime: '',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    const employee = JSON.parse(options.employee); // 获取传递过来的岗位信息
    // // 获取当前本地时间  
    let now = new Date();  
      
    // // 格式化日期时间（可选）  
    let year = now.getFullYear();  
    let month = String(now.getMonth() + 1).padStart(2, '0'); // 月份是从0开始的，所以要加1  
    let day = String(now.getDate()).padStart(2, '0');  
    let hours = String(now.getHours()).padStart(2, '0');  
    let minutes = String(now.getMinutes()).padStart(2, '0');  
    let seconds = String(now.getSeconds()).padStart(2, '0');  
      
    // 拼接成完整的日期时间字符串  
    let localDateTime = `${year}-${month}-${day}T${hours}:${minutes}:${seconds}`;  
    
    // // 输出或使用本地时间  
    console.log(localDateTime);  
    // // 或者将数据设置到页面数据中以供显示  
    this.setData({  
      localDateTime: localDateTime,
    });
    this.setData({
      employee: employee,
    });
  },
  
  // 用户输入离职类型时触发
  inputType: function(e) {
    this.setData({
      dimissionType: e.detail.value, // 更新部门名称
    });
  },

  // 用户输入离职日期时触发
  inputDate: function(e) {
    console.log(this.data.dimissionDate)
    this.setData({
      dimissionDate: e.detail.value,
    });
  },

  // 用户输入离职去向时触发
  inputHead: function(e) {
    this.setData({
      dimissionGo: e.detail.value, // 更新部门名称
    });
  },
  // 用户输入备注时触发
  inputInfo: function(e) {
    this.setData({
      note: e.detail.value, // 更新部门名称
    });
  },
  handleDelete: function (e) {
    // const employee = this.data.employee; // 获取信息
    // const newInfo = {
    //   dimissionType: this.data.dimissionType,
    //   dimissionGo: this.data.dimissionGo,
    //   note: this.data.note,
    //   // 其他部门信息字段
    // };
    console.log(this.data.employee.employeeId);
    console.log(this.data.dimissionDate);
    console.log(this.data.dimissionType);
    console.log(this.data.dimissionGo);
    console.log(this.data.note);
          wx.request({
            url: 'http://localhost:8080/employee/InsertDimissionInfo', // 修改为你的后端接口地址
            method: 'PUT',
            data: {
              employeeId: this.data.employee.employeeId,
              dimissionDate: this.data.localDateTime,
              dimissionType: this.data.dimissionType,
              dimissionGo: this.data.dimissionGo,
              note: this.data.note,
            },
            success: (res) => {
              if (res.data.code === 1) {
                wx.navigateBack({
                  delta: 1, // 返回页面数，这里假设是返回到上一个页面
                });
              } else {
                // 删除失败，显示错误信息
                wx.showToast({
                  title: res.data.msg || '删除失败',
                  icon: 'none'
                });
              }
            },
            fail: (err) => {
              // 请求失败，显示错误提示
              wx.showToast({
                title: '请求失败，请重试',
                icon: 'none'
              });
            }
          });
  },
  // 返回原界面
  cancel: function() {
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