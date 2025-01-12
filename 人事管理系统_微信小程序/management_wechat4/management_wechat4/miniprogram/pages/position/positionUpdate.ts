Page({
  data: {
    position: {}, // 用于保存岗位信息
  },

  onLoad: function (options) {
    const position = JSON.parse(options.position); // 获取传递过来的岗位信息
    this.setData({
      position: position,
    });
  },

  // 用户输入岗位名称时触发
  inputPositionName: function (e) {
    const value = e.detail.value;
    this.setData({
      'position.positionName': value, // 更新岗位名称
    });
  },

  // 用户输入岗位类型时触发
  inputPositionType: function (e) {
    const value = e.detail.value;
    this.setData({
      'position.positionType': value, // 更新岗位类型
    });
  },

  // 用户输入岗位编制时触发
  inputPositionNum: function (e) {
    const value = e.detail.value;
    this.setData({
      'position.positionNum': value, // 更新岗位编制
    });
  },

  // 确认编辑
  savePosition: function () {
    const position = this.data.position; // 获取部门信息
    wx.request({
      url: 'http://localhost:8080/position/update', // 修改为你的后端接口地址
      method: 'PUT',
      data: {
        positionId: position.positionId,
        positionName: position.positionName,
        positionType: position.positionType,
        positionNum: position.positionNum, 
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
                    prevPage.update(position); // 调用上一个页面的更新岗位信息方法
                  } else {
                    console.error("上一个页面不存在 update 方法");
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

    // 取消修改岗位，返回原界面
    cancelUpdate: function() {
      wx.navigateBack({
        delta: 1, // 返回页面数，这里假设是返回到上一个页面
      });
    },
});
