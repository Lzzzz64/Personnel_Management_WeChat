Page({
  // 添加界面的数据
  data: {
    employee: {
      employeeId: '', // 员工号
      employeeName: '', // 员工姓名
      foreign: [] // 外语技能列表
    },
    type: '',
    proficiency: '1',
    
  },

  onLoad: function (options) {
    const employee = JSON.parse(options.employee); // 获取传递过来的员工信息
    // 如果员工信息中没有外语技能列表，新建一个空数组
    if (!employee.foreign) {
      employee.foreign = [];
    }
    this.setData({
      employee: employee,
    });
  },

  // 用户输入语种时触发
  inputForeignType: function (e) {
    this.setData({
      type : e.detail.value
    });
  },

  changeProficiency: function (e) {
    this.setData({
      proficiency : e.detail.value
    });
  },

  
  // 确认添加
  addForeign: function () {
    const employee = this.data.employee; // 获取员工信息
    const newForeign = {
      employeeId: this.data.employee.employeeId,
      type: this.data.type,
      proficiency: this.data.proficiency,
      // 其他部门信息字段
    };
    employee.foreign.push(newForeign);
    console.log(employee)
    wx.request({
      url: 'http://localhost:8080/foreign', // 修改为你的后端接口地址
      method: 'PUT',
      header: {
        'content-type': 'application/json' // 设置请求头为 JSON 格式
      },
      data: employee, // 直接发送员工信息对象
      success: (res) => {
        if (res.data.code === 1) {
          // 更新成功，提示用户并返回上一页
          wx.showToast({
            title: '更新成功',
            icon: 'success',
            duration: 2000,
            success: () => {
              wx.navigateBack({
                delta: 1,
                success: () => {
                  const pages = getCurrentPages();
                  const prevPage = pages[pages.length - 1];
                  if (prevPage && prevPage.update) {
                    prevPage.update(employee); // 调用上一个页面的更新部门信息方法
                  } else {
                    console.error("上一个页面不存在 updateEmployee 方法");
                  }
                }
              });
            }
          });
        } else {
          // 更新失败，显示错误信息
          wx.showToast({
            title: res.data.msg || '更新失败',
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



  // 取消添加部门，返回原界面
  cancelAdd: function () {
    wx.navigateBack({
      delta: 1, // 返回页面数，这里假设是返回到上一个页面
    });
  },
});
