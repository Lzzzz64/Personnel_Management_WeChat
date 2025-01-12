Page({
  // 添加界面的数据
  data: {
    positionId: '', // 岗位编号
    positionName: '', // 岗位名称
    positionType: '', // 岗位类型
    positionNum: '', // 岗位编制
  },

  // 用户输入岗位名称时触发
  inputPositionName: function (e) {
    this.setData({
      positionName: e.detail.value, // 更新岗位名称
    });
  },

  // 用户输入岗位编号时触发
  inputPositionId: function (e) {
    this.setData({
      positionId: e.detail.value, // 更新岗位名称
    });
  },

  // 用户输入岗位编号时触发
  inputPositionType: function (e) {
    this.setData({
      positionType: e.detail.value, // 更新岗位类型
    });
  },

  // 用户输入岗位编制时触发
  inputPositionNum: function (e) {
    this.setData({
      positionNum: e.detail.value, // 更新岗位编制
    });
  },
  // 确认添加
  addposition: function () {
    // 请求成功后返回上一个页面，并携带新添加的部门信息
    const newPosition = {
      positionId: this.data.positionId,
      positionName: this.data.positionName,
      positionType: this.data.positionType,
      positionNum: this.data.positionNum,
    };
    console.log(newPosition)
    // 假设这里向后端发送保存部门信息的请求
    wx.request({
      url: 'http://localhost:8080/position', // 修改为你的后端接口地址
      method: 'POST',
      data: newPosition,
      success: function (res) {
        if (res.data.code === 1) {
          // 添加成功，提示用户并返回上一页
          wx.showToast({
            title: '添加成功',
            icon: 'success',
            duration: 2000,
            success: function () {
              wx.navigateBack({
                delta: 1,
                success: () => {
                  const pages = getCurrentPages();
                  const prevPage = pages[pages.length - 1];
                  if (prevPage && prevPage.add) {
                    prevPage.add(newPosition); // 调用上一个页面的更新岗位信息方法
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
      fail: function (err) {
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
});
