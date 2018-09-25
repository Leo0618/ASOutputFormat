## AndroidStudio打包apk输出文件目录自定义

> 烦恼背景：每次AS打包后输出的apk会自动生成到指定的目录下，mapping文件也会在build目录下，打包完成需求去拷贝出来，很是麻烦，于是乎，也许可以实现将编译生成的apk包及mapping文件移到自己想要的一个项目目录里面，那岂不是美滋滋，于是就有了这篇文章。


### 混淆规则指定生成mapping

proguard-rules.pro中加入生成mapping文件语句，如下：

![生成mapping文件语句](https://i.imgur.com/Xritsrq.png)



### build文件配置的必要条件

要实现指定输出位置，还需要app目录下的build.gradle文件需要至少有如下几点的配置：

- buildTypes需要有release类型的配置
- productFlavors作为可选，可以不用配置，多渠道打包可使用其他方式（360加固保、美团多渠道打包工具等等）
- 最后一步做的就是应用gradle文件，在app目录下的build.gradle里面最末尾加入一行代码 `apply from: '../output_format.gradle'` , 并且你需要将output_format.gradle这个文件拷贝到你的项目根目录，文件下载

### 正常编译打包，输出效果
![](https://i.imgur.com/YbyXd10.png)



### 自己定义名称的方法

可以根据自己情况设置输出根目录名称、mapping文件名称、apk文件名称、是否删除多渠道的原包apk目录等配置，在如下代码位置处修改：


```
/**
 * 定义输出根目录名称
 * @param versionName 可用的参数：当前打包版本名称
 * @param versionCode 可用的参数：当前打包版本号码
 * @param flavorName 可用的参数：flavor名称，此参数可能为空字符串
 */
@SuppressWarnings("GroovyUnusedDeclaration")
static String outputFileDirName(versionName, versionCode, flavorName) {
    return "output/app_release-v" + versionName + "-" + versionCode + "-" + dateRelease()
}

/**
 * 定义输出mapping文件名称
 * @param versionName 可用的参数：当前打包版本名称
 * @param versionCode 可用的参数：当前打包版本号码
 * @param flavorName 可用的参数：flavor名称，此参数可能为空字符串
 */
@SuppressWarnings("GroovyUnusedDeclaration")
static String mappingFileName(versionName, versionCode, flavorName) {
    return "mapping-v" + versionName + "-" + versionCode + "-" + dateRelease() + ".txt"
}

/**
 * 定义输出apk文件名称
 * @param versionName 可用的参数：当前打包版本名称
 * @param versionCode 可用的参数：当前打包版本号码
 * @param flavorName 可用的参数：flavor名称，此参数可能为空字符串
 */
@SuppressWarnings("GroovyUnusedDeclaration")
static String apkFileName(versionName, versionCode, flavorName) {
    return "app-release-v" + versionName + "-" + versionCode + "-" + dateRelease() + ".apk"
}

/**
 * 是否删除多渠道的原包apk目录
 */
static boolean deleteInitApk() {
    return true
}
```
