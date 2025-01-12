  Page({
    // 添加界面的数据
    data: {
      employeeId:'', //员工号
      startTime:'', //起始年月
      endTime:'',  //截止年月
      organizationName:'',  //所在单位名称
      position:'',  //担任职务
      jobDescription:'',  //从事工作内容
      salary:'',  //月薪
      note:'' //备注
    },

    onLoad: function (options) {
      const employee = JSON.parse(options.employee); // 获取传递过来的员工信息
      this.setData({
        employee: employee,
      });
      console.log("传输的员工数据：", employee);
    },
    
      // 用户输入人际关系名称时触发
      inputStartTime: function (e) {
        const value = e.detail.value;
        this.setData({
          'startTime': value,
        });
      },
        // 用户输入部门名称时触发
        inputEndTime: function (e) {
      const value = e.detail.value;
      this.setData({
        'endTime': value, // 更新部门名称
      });
    },
      // 用户输入部门名称时触发
      inputOrganizationName: function (e) {
        const value = e.detail.value;
        this.setData({
          'organizationName': value, // 更新部门名称
        });
      },
        // 用户输入部门名称时触发
        inputPosition: function (e) {
      const value = e.detail.value;
      this.setData({
        'position': value, // 更新部门名称
      });
    },
    // 用户输入部门名称时触发
    inputJobDescription: function (e) {
      const value = e.detail.value;
      this.setData({
        'jobDescription': value, // 更新部门名称
      });
    },
    // 用户输入部门名称时触发
    inputSalary: function (e) {
      const value = e.detail.value;
      this.setData({
        'salary': value, // 更新部门名称
      });
    },
    // 用户输入部门名称时触发
    inputNote: function (e) {
      const value = e.detail.value;
      this.setData({
        'note': value, // 更新部门名称
      });
    },
    // 确认编辑
    savePosition: function () {
      const employee = this.data.employee; // 获取信息
      const careerData = this.data.employee.career;

      /*  // 更新备注信息
      const note = this.data.note;
      employee.career.forEach(career => {
        career.note = note;
      });  */

     // 获取用户输入的值
    const startTime = this.data.startTime;
    const endTime = this.data.endTime;
    const organizationName = this.data.organizationName;
    const position = this.data.position;
    const jobDescription = this.data.jobDescription;
    const salary = this.data.salary;
    const note = this.data.note;

    // 更新员工的每个工作经历对象中用户输入的信息
    employee.career.forEach(career => {
      if (startTime !== '') career.startTime = startTime;
      if (endTime !== '') career.endTime = endTime;
      if (organizationName !== '') career.organizationName = organizationName;
      if (position !== '') career.position = position;
      if (jobDescription !== '') career.jobDescription = jobDescription;
      if (salary !== '') career.salary = salary;
      if (note !== '') career.note = note;
    });


      console.log(employee);
      wx.request({
        url: 'http://localhost:8080/career', // 修改为你的后端接口地址
        method: 'PUT',
        header: {
          'content-type': 'application/json' // 设置请求头为 JSON 格式
        }, 
        data: JSON.stringify({
          employeeId: employee.employeeId,
          employeeName: employee.employeeName,
          career: careerData
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
        const career = this.data.employee.career;
        wx.showModal({
          title: '提示',
          content: '确定要删除该岗位吗？',
          success: (res) => {
            if (res.confirm) {
              // 用户点击了确定按钮，向后端发送删除请求
                career.splice(index, 1); // 删除指定索引的项
                this.setData({
                  'employee.career': career
                });
                
              wx.navigateTo({
                url: '/pages/employee/careerQuery?employee=' + JSON.stringify(employee),
              });
            }
          }
        });


      }
  });
