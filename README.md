# PrecomputedtTextTaste
PrecomputedtText Demo

Android P 新特性

使用PrecomputedText 据说可以异步测量文本，节约渲染时间。

Demo 中实现了 普通 TextView 的文本渲染以及 RecyclerView 中 TextView 的文本渲染。

首页是使用PrecomputedText 渲染的文本，SecondActivity是使用普通的 setText()渲染的文本。
可以打开 开发者选项 -> GPU呈现模式分析 -> 屏幕显示条形图 
然后分析渲染消耗。


具体参考文章：

[https://medium.com/androiddevelopers/prefetch-text-layout-in-recyclerview-4acf9103f438](https://medium.com/androiddevelopers/prefetch-text-layout-in-recyclerview-4acf9103f438)

[https://medium.com/mindorks/precomputedtext-new-api-in-android-pie-74eb8f420ee6](https://medium.com/mindorks/precomputedtext-new-api-in-android-pie-74eb8f420ee6)
