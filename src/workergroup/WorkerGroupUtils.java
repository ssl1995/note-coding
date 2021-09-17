package workergroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author SongShengLin
 * @date 2021/9/16 10:40 下午
 * @description
 */
public class WorkerGroupUtils {
    // 需求1：分组，25人一组，条件是组内员工相差不超过5岁；男女比例相当；入职时间混排
    // 获得公司员工数据，allWorkers需要公司员工的数据
    private static List<Worker> allWorkers = new ArrayList<>();
    // 分组，每组25人：男生12人，女生13人
    private static final int MAN_COUNT = 12;
    private static final int WOMAN_COUNT = 13;

    // 需求2：分房，员工相差不超过5岁，入职时间混排
    private static List<Worker> manWorkers = allWorkers.stream().filter(w -> w.getSex() == 0).collect(Collectors.toList());
    private static List<Worker> womanWorkers = allWorkers.stream().filter(w -> w.getSex() == 1).collect(Collectors.toList());


    /**
     * 获取一组团建分组的集合
     *
     * @return
     */
    public static List<Worker> getOneGroupList() {
        // 检查原始数据
        checkWorkersCount();
        List<Worker> groupList = new ArrayList<>();
        Worker firstWorker = allWorkers.get((int) (Math.random() * allWorkers.size()));
        // 移除该名员工
        allWorkers.remove(firstWorker);
        int age = firstWorker.getAge();
        // 0-男生，1-女生
        int sex = firstWorker.getSex();
        for (int i = 0; i < MAN_COUNT; i++) {
            groupList.add(getManWorker(age));
        }
        for (int i = 0; i < WOMAN_COUNT; i++) {
            groupList.add(getWoManWorker(age));
        }
        return groupList;
    }

    /**
     * 检查总员工数，是否<=25
     */
    private static void checkWorkersCount() {
        if (allWorkers.size() <= WOMAN_COUNT + MAN_COUNT) {
            throw new RuntimeException("员工总人数<=25，不用再分组");
        }
    }

    /**
     * 获得下一个男生员工，并且在总集合中移除
     *
     * @param age 上一名员工的年纪
     * @return 下一个男生员工
     */
    private static Worker getManWorker(int age) {
        List<Worker> nextList = allWorkers.stream()
                // 年级不超过5岁，指定为男生
                .filter(w -> Math.abs(w.getAge() - age) <= 5).filter(w -> w.getSex() == 0)
                .collect(Collectors.toList());
        Worker worker = nextList.get((int) (Math.random() * nextList.size()));
        // 总员工中移除该名员工
        allWorkers.remove(worker);
        return worker;
    }

    /**
     * 获得下一个女生员工，并且在总集合中移除
     *
     * @param age 上一名员工的年纪
     * @return 下一个女生员工
     */
    private static Worker getWoManWorker(int age) {
        List<Worker> nextList = allWorkers.stream()
                // 年级不超过5岁，指定为女生
                .filter(w -> Math.abs(w.getAge() - age) <= 5).filter(w -> w.getSex() == 1)
                .collect(Collectors.toList());
        Worker worker = nextList.get((int) (Math.random() * nextList.size()));
        // 总员工中移除该名员工
        allWorkers.remove(worker);
        return worker;
    }


    /**
     * 获取一组男生分房的集合
     *
     * @return
     */
    public static List<Worker> getOneManGroup() {
        if (manWorkers.size() <= 2) {
            return manWorkers;
        }
        Worker firstWorker = manWorkers.get((int) (Math.random() * manWorkers.size()));
        // 男集合中移除该名员工
        manWorkers.remove(firstWorker);

        int age = firstWorker.getAge();
        List<Worker> res = new ArrayList<>();
        res.add(firstWorker);

        List<Worker> nestList = manWorkers.stream().filter(w -> Math.abs(w.getAge() - age) <= 5).collect(Collectors.toList());
        Worker nextWork = nestList.get((int) (Math.random() * nestList.size()));
        res.add(nextWork);
        return res;
    }

    /**
     * 获取一组女生分房的集合
     *
     * @return
     */
    public static List<Worker> getOneWoManGroup() {
        if (womanWorkers.size() <= 2) {
            return womanWorkers;
        }
        Worker firstWorker = womanWorkers.get((int) (Math.random() * womanWorkers.size()));
        // 女集合中移除该名员工
        womanWorkers.remove(firstWorker);

        int age = firstWorker.getAge();
        List<Worker> res = new ArrayList<>();
        res.add(firstWorker);

        List<Worker> nestList = womanWorkers.stream().filter(w -> Math.abs(w.getAge() - age) <= 5).collect(Collectors.toList());
        Worker nextWork = nestList.get((int) (Math.random() * nestList.size()));
        res.add(nextWork);
        return res;
    }

}
