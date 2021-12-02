## JOC - Java Doc

#### 通过注释生成Java文档

```
Bootstrap - start(String path, Set<String> exclude): 启动器,从path开始,扫描内部的所有java类的文件

Scanner - scan(File file): List<T>  扫描一个文件,返回扫描文件后返回的信息
|
|_ _ AnnotationScanner - scan(File file): List<Annotation> 注释扫描器,返回扫描文件后的注释

Parser - parse(T doc): Map 解析信息,解析结果以{标签: 结果}的信息返回
|
|_ _ AnnotationParser - parse(Annotation doc): Map 解析注释信息,结果以{标签: AnnotationResult}的形式返回,{"param": {"id": "工单id", "status": "工单状态"}, "return": "返回xxx的对象", "throw": {"RuntimeException": "运行时", "Exception": "异常"}}

Appender - append(String content): 追加器,把解析后的文本追加到目标地
|
|_ _ FileAppender(String filename) - append(String content): void 文件追加器,把文本追加到文件
```