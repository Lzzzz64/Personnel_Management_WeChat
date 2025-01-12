Page({
  // 添加界面的数据
  data: {
    employee:{
    employeeId: '', //员工号
    employeeName: '', //员工姓名
    foreign:[],
    // type: '', // 语种
    // proficiency: '', // 熟练程度
    }
  }, 
  
  onLoad: function (options) {
    const employee = JSON.parse(options.employee); // 获取传递过来的员工信息
    this.setData({
      employee: employee,
    });
  },
  
  // 确认编辑
  savePosition: function () {
    const employee = this.data.employee; // 获取信息
    const foreignData = this.data.employee.foreign;
    wx.request({
      url: 'http://localhost:8080/foreign', // 修改为你的后端接口地址
      method: 'PUT',
      header: {
        'content-type': 'application/json' // 设置请求头为 JSON 格式
      }, 
       data: JSON.stringify({
        employeeId: employee.employeeId,
        employeeName: employee.employeeName,
        foreign: foreignData
      }),
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

    // 取消添加岗位，返回原界面
    cancelAdd: function() {
      wx.navigateBack({
        delta: 1, // 返回页面数，这里假设是返回到上一个页面
      });
    },

    handleDelete: function(e) {
      const index = e.currentTarget.dataset.index;
      const foreign = this.data.employee.foreign;
      foreign.splice(index, 1); // 删除指定索引的项
      this.setData({
        'employee.foreign': foreign
      });
    },
    changeProficiency: function(e) {
      const index = e.currentTarget.dataset.index;
      const value = e.detail.value;
      const foreign = this.data.employee.foreign;
      foreign[index].proficiency = value; // 更新选择的值
      this.setData({
        'employee.foreign': foreign
      });
    }

});

