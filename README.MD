## JOC - Java Doc

#### 通过注释生成Java文档

```
Bootstrap - start(): 启动器,从本项目根目录开始扫描,扫描内部的所有java类的文件

doclet - javadoc执行后将结果返回给Joclet,Joclet解析返回结果获取注释

Scanner - scan(File file): List<T>  扫描一个文件,返回扫描文件后返回的信息
|
|_ _ CommentScanner - scan(File file): List<Comment> 注释扫描器,返回扫描文件后的注释

Appender - append(String content): 追加器,把解析后的文本追加到目标地
|
|_ _ FileAppender(String filename) implement Closeable - append(String content): void 文件追加器,把文本追加到文件
```