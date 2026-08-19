# Netty Proxy Spring Boot Starter

一个为Spring Boot应用提供 **Reactor Netty HttpClient代理支持**的自动配置Starter。

它通过注入一个自定义的`ClientHttpConnector`Bean，启用`SystemProperties`，使应用底层基于Reactor Netty的HTTP客户端（如
`WebClient`）能够通过HTTP/SOCKS代理访问外部服务。

----

适用场景：

* 你的应用使用Spring Boot 3.x和WebFlux，且内部通过`WebClient`发起请求。
* 应用部署在隔离网络环境（如内网），需要通过代理访问外部服务（例如更新检查、API调用）。
* 你希望以无侵入的方式为应用添加代理支持，无需修改应用源码或重新打包主JAR。

## 特性

* **零代码侵入**：通过Spring Boot自动配置机制，仅需添加JAR并配置属性即可生效。
* **支持多种代理类型**：HTTP、HTTPS、SOCKS4、SOCKS5。
* **支持认证**：可配置用户名/密码。
* **自动集成**：利用 `ClientHttpConnectorAutoConfiguration`，自动将定制的连接器应用到所有`WebClient.Builder`实例。

## 快速开始

### 1.引入依赖

由于该项目尚未发布到Maven中央仓库，你需要自行编译并添加到项目中。

**Maven方式（本地安装）**

```bash
git clone <your-repo>
cd netty-proxy-starter mvn clean install
```

然后在你的项目`pom.xml`中添加：

```xml

<dependency>
    <groupId>com.bluewhalemain</groupId>
    <artifactId>netty-proxy-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

**直接使用JAR包**

```bash
mvn clean package
```

将JAR通过`-cp`或`loader.path`添加到应用的类路径中。

### 2.部署

配置形如`-Dhttp.proxyHost=squid -Dhttp.proxyPort=3128`的参数。

### 3.启动

控制台输出`Creating HttpClient Connector...`代表代理配置已加载（需要应用支持Slf4j）。

## 前置要求

* JDK 17+
* Maven 3.6+

## 许可证

MIT License
