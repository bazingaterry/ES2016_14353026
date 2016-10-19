# Lab 3

## Task
1. 修改 example2，让三个 square 模块变成两个。
2. 修改 example1，使其输出 3 次方数。

### Task 1

从 xml 分析整个架构，发现有如下这一段是一个循环连接 square 模块。

```xml
<iterator variable="i" range="N">
  <process name="square">
    <append function="i"/>
    <port type="input" name="0"/>
    <port type="output" name="1"/>
    <source type="c" location="square.c"/>
  </process>
</iterator>
```

而 N 在上面的 `<variable value="3" name="N"/>` 被定义。

让三个 square 模块变成两个，只需要把 N 赋值为 2 即可。即改为 `<variable value="2" name="N"/>`。

编译运行测试。

```bash
rm -rf build
ant -f build_zip.xml all
ant -f build/bin/main/runexample.xml -Dnumber=2
```

![](https://static.32ph.com/upload-pic/jynmj.jpg)

![](https://static.32ph.com/upload-pic/d7omi.jpg)

### Task 2

观察 square.c 文件，发现在如下代码中定义了 square 模块的逻辑。

```c
int square_fire(DOLProcess *p) {
    float i;

    if (p->local->index < p->local->len) {
        DOL_read((void*)PORT_IN, &i, sizeof(float), p);
        i = i*i;
        DOL_write((void*)PORT_OUT, &i, sizeof(float), p);
        p->local->index++;
    }

    if (p->local->index >= p->local->len) {
        DOL_detach(p);
        return -1;
    }

    return 0;
}
```

其中 `i = i*i;` 使其输出平方数，修改为 `i = i*i*i;`。

编译运行测试。

![](https://static.32ph.com/upload-pic/llg11.jpg)

![](https://static.32ph.com/upload-pic/3tejq.jpg)

## Experimental experience

DOL 真是一个优雅方便的仿真框架。
