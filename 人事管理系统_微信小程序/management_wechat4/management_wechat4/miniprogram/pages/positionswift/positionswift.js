Page({

  /**
   * 页面的初始数据
   */
  data: {
    employee: {}, // 用于保存员工信息
    dimissionInformation:{},
    dimissionDate: '',
    transferType: '', //离职类型 
    transferPositionId: '', // 部门号
    transferReason: '',
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
      transferPositionId: e.detail.value, // 更新部门名称
    });
  },
  // 用户输入备注时触发
  inputInfo: function(e) {
    this.setData({
      note: e.detail.value, // 更新部门名称
    });
  },

  // 原因
  inputReason: function(e) {
    this.setData({
      transferReason: e.detail.value, // 
    });
  },
  inputType: function(e) {
    this.setData({
      transferType: e.detail.value, // 
    });
  },

  handleSwift: function (e) {
    console.log(this.data.employee.employeeId);
    console.log(this.data.dimissionGo);
    console.log(this.data.dimissionType);
    console.log(this.data.dimissionReason);
    console.log(this.data.note);
    console.log(this.data.localDateTime);
          wx.request({
            url: 'http://localhost:8080/employee/InsertPosition', // 修改为你的后端接口地址
            method: 'PUT',
            data: {
              employeeId: this.data.employee.employeeId,//员工号
              transferPositionId: this.data.transferPositionId,//岗位号
              transferType: this.data.transferType,//调转类型
              transferReason: this.data.transferReason,//调转原因
              transferDate: this.data.localDateTime,//调动日期
              note: this.data.note,//备注
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

  cancel: function() {
    wx.navigateBack({
      delta: 1, // 返回页面数，这里假设是返回到上一个页面
    });
  },
})