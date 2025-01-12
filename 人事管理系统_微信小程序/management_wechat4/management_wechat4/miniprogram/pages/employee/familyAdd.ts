Page({
  // 添加界面的数据
  data: {
  employeeId:'', //员工号
  relationship:'', //与本人关系 父亲、母亲、配偶
  name:'',//姓名
  organization:'', //所在单位
  phone:'',
  },

  onLoad: function (options) {
    const employee = JSON.parse(options.employee); // 获取传递过来的员工信息
    if (!employee.relation) {
      employee.relation = [];
    }
    this.setData({
      employee: employee,
    });
    console.log("传输的员工数据：", employee);
  },
  
    // 用户输入部门名称时触发
    inputRelationship: function (e) {
      const value = e.detail.value;
      this.setData({
        'employee.relationship': value, // 更新部门名称
      });
    },
      // 用户输入部门名称时触发
      inputName: function (e) {
    const value = e.detail.value;
    this.setData({
      'employee.name': value, // 更新部门名称
    });
  },
    // 用户输入部门名称时触发
    inputOrganization: function (e) {
      const value = e.detail.value;
      this.setData({
        'employee.organization': value, // 更新部门名称
      });
    },
      // 用户输入部门名称时触发
      inputPhone: function (e) {
    const value = e.detail.value;
    this.setData({
      'employee.phone': value, // 更新部门名称
    });
  },
  // 确认编辑
  savePosition: function () {
    const employee = this.data.employee; // 获取信息
    const newRelation = {
      employeeId: this.data.employee.employeeId,
      relationship: this.data.employee.relationship,
      name: this.data.employee.name,
      organization:this.data.employee.organization,
      phone: this.data.employee.phone,
      // 其他部门信息字段
    };
    employee.relation.push(newRelation);
    wx.request({
      url: 'http://localhost:8080/relation', // 修改为你的后端接口地址
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

    // 取消添加岗位，返回原界面
    cancelAdd: function() {
      wx.navigateBack({
        delta: 1, // 返回页面数，这里假设是返回到上一个页面
      });
    },

    handleDelete: function(e) {
      const index = e.currentTarget.dataset.index;
      const relation = this.data.employee.relation;
      wx.showModal({
        title: '提示',
        content: '确定要删除该岗位吗？',
        success: (res) => {
          if (res.confirm) {
            // 用户点击了确定按钮，向后端发送删除请求
              relation.splice(index, 1); // 删除指定索引的项
              this.setData({
                'employee.relation': relation
              });
              
            wx.navigateTo({
              url: '/pages/employee/familyAdd?employee=' + JSON.stringify(employee),
            });
          }
        }
      });


    }
});
