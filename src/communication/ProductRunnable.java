package communication;

public class ProductRunnable implements Runnable{
    //private Product product = new Product();
    private Product product = null;

    public ProductRunnable(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (product) {
                //如果已经有了商品，就等待
                if (product.flag) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //生产商品并输出结果
                if(i % 2 == 0){
                    //生产馒头；
                    product.setName("馒头");
                    product.setColor("白色");
                }else{
                    //生产玉米饼
                    product.setName("玉米饼");
                    product.setColor("黄色");
                }
                System.out.println("生产者在生产商品" + product.getName() + " " + product.getColor());

                //改变商品的状态（有商品了）
                product.flag = true;

                //通知消费者可以消费
                product.notify();
            }

            i++;
        }
    }
}
