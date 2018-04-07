第一章 基础

基础编程模型

3:23  1.1

Javac 编译  -> java运行

java 4种基本数据类型：int double boolean char   其他五种原始数据类型：long short char byte float 这里的

i/=2 

重载

左声明（数组名称和数据类型）右创建（数组长度）double[] a = new double[N]   之后初始化赋值3:58

复制数组的问题，注意和起别名

4:05-4:27 为什么休息时候过的那么快

颠倒数组，用二分互换

数组初始化默认值是0

静态方法称为函数，static 将静态方法与实例方法相区别

静态方法库：类中的函数

你应该将自己编写的每一个程序都当作日后可重用的库

main(String args[]) 里面的参数是 我们输入的命令行参数

标识符表示变量

根据上下文 同样的运算符对不同类型会执行不同操作，这些运算符都是被重载过的 5/3 5.0/3.0 && ||

5:19

5:34

 问1    欧几里得 求 最大公约数 原因？      

           首先存在c = gcd(a, b), a = k1*c, b = k2*c

           余数a%b = r;   r = a - k3*b=(k1-k2*k3)*c 因此r一定是c的倍数，所以原理就是，

           通过模运算的余数是最大公约数之间存在的整数倍的关系，来给比较大的数字进行降维

问2     char的位数

           A char represents a character in Java (*). It is 2 bytes large. That doesn't necessarily mean that 

          every representation of a character is 2 bytes long. In fact many encodings only reserve 1 byte 

          for every character (or use 1 byte for the most common characters).变string之后就要看编码了 直接怎么 

          得到有多少字节没看到。。。

问3

    ｛int i=0;  int j=i++;｝
    ｛int i=0; int z=++i;}
    运算过后，j=0；表明i++是指先把i赋值给j然后再自身加1；
    运算过后，z=1；表明++i是指先自身加1后赋值给z；
    总之记住++号在后面的意思是先赋值然后自身加1；++在前面的是先自身加1后赋值；

实现  isPrime() BinarySearch()------sqrt() TODO 10:34-12:06   第26页

数据抽象

9:14

数据类型指的是 一组值 和 一组对这些值操作的集合  问1><整醒取值范围

如果值在初始化之后，不应该再被改变，就在前面加final

如果一个类中，没有定义构造函数（总是与类同名），类将会隐式定义一个默认情况下不接受任何参数的构造函数，并将所有实例变量初始化为默认值

接口 interface

封装类型 Character Double等等

这书前面都在讲java

背包 队列 栈

自动将一个原始数据类型转换成封装类型称为 自动装箱

背包是一种不支持从中删除元素的集合数据类型，他的目的就是帮助用例收集并遍历所有收集到的元素，顺序不重要，可以根据要求访问某元素，检查背包中元素数量

实现：双栈算术表达式求值 p92

范型

在java中 数组一旦创建 其大小无法改变

理解了迭代器的实现 good 

实现任意插入和删除的标准操作是使用双向链表，问1 练习1.3.31 

算法分析

需要整理   算法分析中常用的近似函数p129

问1 为什么if 判断比较语句一般不算时间呢？

问2 threesum 暴力解决  时间为什么是 n(n-1)(n-2)/6 ? 不会且没查着 

three sum的二分查找代码 

算内存比较简单：只需将变量的数量和它们的类型所对应的字节数分别相乘并汇总即可

使用substring不会额外占用内存 会和原来字符串共用

例子














