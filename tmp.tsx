import React, { useEffect, useState } from "react";
import SwaggerUI from "swagger-ui-react";
import spec from "./result.yml"
import "./App.css"
import { ArrowLeftOutlined } from '@ant-design/icons';
import "swagger-ui-react/swagger-ui.css";
import { Form, Input, Button, Drawer, Modal, Space, Typography, message } from "antd";

const { info } = Modal;

function App() {
  const [token, setToken] = useState(localStorage.getItem("token") || "")
  const [visible, setVisible] = useState(false);

  const showDrawer = () => {
    setVisible(true);
  };

  const onClose = () => {
    setVisible(false);
  };

  const handleReset = ()=>{
    setToken(localStorage.getItem("token") || "")
    message.info("Reseted")
  }

  const onFinish = (values) => {
    if (values.token) {
      setToken(values.token)
      message.info("Override token success!!!!")
    }
  }

  const requestInterceptor = (req) => {
    // Set the default authentication token
    req.headers.Authorization = token
    return req;
  }

  return (
    <div className="App">
      <div style={{
        display: 'flex',
        position: 'fixed',
        right: '0',
        height: '100vh'
      }}>
        <Typography onClick={showDrawer}
          style={{
            border: '0,1px solid black',
            background: 'blue',
            height: '50px',
            width: '50px',
            color: 'white',
            textAlign: 'center',
            lineHeight: '50px',
            fontSize: '20px'
          }}>
          <ArrowLeftOutlined/>
        </Typography>
        <Drawer
          mask={false}
          maskClosable={false}
          title="Authorization configuration"
          placement="right"
          onClose={onClose}
          open={visible}
          push={true}
          className="drawer">
          <Form
            onFinish={onFinish}
            layout="vertical"
          >
            <Form.Item
              className={'class'}
              label="Authorization"
              name="token"
              rules={[{ required: true, message: 'Please input your token!' }]}
            >
              <Input />
            </Form.Item>
            <Form.Item>
              <Button type="primary" htmlType="submit">
                Save
              </Button>
              <Button type="secondary" onClick={handleReset}>
                Reset
              </Button>
            </Form.Item>
          </Form>
        </Drawer>
      </div>

      <div className={`content ${visible ? "pushed" : ""}`}>
        <SwaggerUI
          url={spec}
          requestInterceptor={requestInterceptor}
        />
      </div>
    </div>

  );
}
export default App;
