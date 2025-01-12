Page({
  data: {
    department: {}, // 用于保存部门信息
  },

  onLoad: function (options) {
    const department = JSON.parse(options.department); // 获取传递过来的部门信息
    this.setData({
      department: department,
    });
  },

  // 用户输入部门名称时触发
  inputDepartmentName: function (e) {
    const value = e.detail.value;
    this.setData({
      'department.departmentName': value, // 更新部门名称
    });
  },

  
  // 确认编辑
  saveDepartment: function () {
    const department = this.data.department; // 获取部门信息
    wx.request({
      url: 'http://localhost:8080/department/update', // 修改为你的后端接口地址
      method: 'PUT',
      data: {
        departmentId: department.departmentId,
        departmentName: department.departmentName
      },
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
                    prevPage.update(department); // 调用上一个页面的更新部门信息方法
                  } else {
                    console.error("上一个页面不存在 updateDepartment 方法");
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

    // 取消修改部门，返回原界面
    cancelUpdate: function() {
      wx.navigateBack({
        delta: 1, // 返回页面数，这里假设是返回到上一个页面
      });
    },
});
