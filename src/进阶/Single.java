package 进阶;

// 使用Java实现一个单例
public class Single {
    // 1.私有构造函数
    private Single() {
    }
    // 2.对象引用
    private static Single single = null;
    // 3.提供静态方法获取对象引用属性
    private static Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) single = new Single();
            }
        }
        return single;
    }
}
