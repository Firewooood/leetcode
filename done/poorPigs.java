package done;

public class poorPigs {
    public static void main(String[] args) {
        int buckets = 1000, minutesToDie = 15, minutesToTest = 60;
        poorPigs p1 = new poorPigs();
        System.out.println(p1.p1(buckets, minutesToDie, minutesToTest));
    }
    
    /**
     * 有 buckets 桶液体，其中 正好
     * 有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。
     * 为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。
     * 不幸的是，你只有 minutesToTest分钟时间来确定哪桶液体是有毒的。
     * 
     * 喂猪的规则如下：
     * 
     * 选择若干活猪进行喂养 可以允许小猪同时饮用任意数量的桶中的水，并且该过程不需要时间。 
     * 小猪喝完水后，必须有 minutesToDie分钟的冷却时间。
     * 在这段时间里，你只能观察，而不允许继续喂猪。 
     * 过了 minutesToDie 分钟后，所有喝到毒药的猪都会死去，其他所有猪都会活下来。
     * 重复这一过程，直到时间用完。 
     * 给你桶的数目 buckets ，minutesToDie 和 minutesToTest返回在规定时间内判断哪个桶有毒所需的 最小 猪数。
     * 
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int p1(int buckets,int minutesToDie,int minutesToTest)
    {

        /**
         * 经过所有实验，一只小猪能有多少种状态？第一轮就死、第二轮死、...、第n轮死，以及生还，
         * 所以一共有n + 1种状态 n +1种状态所携带的信息为log_2(n + 1)比特，这也是一只小猪最多提供的信息量
         * 而”buckets瓶液体中哪一瓶是毒“这件事，也有buckets种可能性，所以需要的信息量是log_2(buckets)
         */
        if (buckets == 1)
            return 0;
        int num = minutesToTest / minutesToDie + 1;
        //一只小猪最多可以检测num个桶，小猪最多喝minutesToTest / minutesToDie次水，若无问题，则最后一桶水有问题。
        //两只小猪可以一下子喝num桶水，一只猪喝xx行的num瓶水，一只猪喝yy列的num瓶水，则可以测量num^2桶水是否有毒
        int count = num;
        int res = 1;
        while (count < buckets) {
            count *= num;
            res++;
        }
        return res;
    }
}
