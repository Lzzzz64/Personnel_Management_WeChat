Page({
  // 添加界面的数据
  data: {
    departmentId: '', // 部门编号
    departmentName: '', // 部门名称
  },

  // 用户输入部门名称时触发
  inputDepartmentName: function(e) {
    this.setData({
      departmentName: e.detail.value, // 更新部门名称
    });
  },

  // 用户输入部门编号时触发
  inputDepartmentId: function(e) {
    this.setData({
      departmentId: e.detail.value, // 更新部门名称
    });
  },
  // 确认添加
  addDepartment: function() {
    // 请求成功后返回上一个页面，并携带新添加的部门信息
    const newDepartment = {
      departmentId: this.data.departmentId,
      departmentName: this.data.departmentName,
      // 其他部门信息字段
    };

    // 假设这里向后端发送保存部门信息的请求
    wx.request({
      url: 'http://localhost:8080/department', // 修改为你的后端接口地址
      method: 'POST',
      data: newDepartment,
      success: function(res) {
        if (res.data.code === 1) {
          // 添加成功，提示用户并返回上一页
          wx.showToast({
            title: '添加成功',
            icon: 'success',
            duration: 2000,
            success: function() {
              wx.navigateBack({
                delta: 1,
                success: () => {
                  const pages = getCurrentPages();
                  const prevPage = pages[pages.length - 1];
                  if (prevPage && prevPage.add) {
                    prevPage.add(newDepartment); // 调用上一个页面的更新部门信息方法
                  } else {
                    console.error("上一个页面不存在 add 方法");
                  }
                }
              });
            }
          });
        } else {
          // 添加失败，显示错误信息
          wx.showToast({
            title: res.data.msg || '添加失败',
            icon: 'none'
          });
        }
      },
      fail: function(err) {
        // 请求失败，显示错误提示
        wx.showToast({
          title: '请求失败，请重试',
          icon: 'none'
        });
      }
    });
  },

    // 取消添加部门，返回原界面
    cancelAdd: function() {
      wx.navigateBack({
        delta: 1, // 返回页面数，这里假设是返回到上一个页面
      });
    },
});
