let proxyObj = {}

proxyObj['/'] = {
    // WebSocket
    ws: false,
    // 代理要转发到的目标地址
    target: 'http://localhost:8081',
    //发送请求的请求头会被设置为target目标地址中的那个地址
    changeOrigin: true,
    // 不重写请求地址
    pathReWrite: {
        '^/': '/'
    }
}

proxyObj['/ws'] = {
    ws: true,
    target: 'ws://localhost:8081'
}

module.exports = {
    devServer: {
        host: 'localhost',
        port: 8080,
        proxy: proxyObj
    },
    configureWebpack: {
        devtool: 'source-map'
    }
}
