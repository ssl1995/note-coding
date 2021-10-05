package 读书笔记.数据结构By慕课网.查找.二分查找;

public class BinarySearch {
    private BinarySearch() {
    }

    // 标准二分查找
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        // 标准二分:[left,right]两端都是闭区间
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 搜索左侧区间的二分查找:常见写法
    public static int leftBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 起始条件：0,n
        int left = 0, right = nums.length;
        // 左侧区间的二分查找:[l,r)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {// <区间,left是闭区间,所以+1和标准写法一致
                left = mid + 1;
            } else if (nums[mid] > target) {// >区间,right是开区间,等于mid才行
                right = mid;
            } else {// =区间,由于是找左侧边界,收缩右边界即可
                right = mid;
            }
        }
        // 边界条件:[left,nums.len),当left来到nums.len(数组长度的索引处)肯定没找到,返回-1
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    // 搜索左侧区间的二分查找:统一成标准二分查找的写法
    public static int leftBinarySearch1(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // =时，收缩区间
                right = mid - 1;
            }
        }
        // 检查边界
        if (left > nums.length - 1 || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // 右侧区间的二分查找
    public static int rightBinarySearch1(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 起始条件：0,n
        int left = 0, right = nums.length;
        // 左侧区间的二分查找:[l,r)
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                // =时,查找右侧区间,left变大
                left = mid + 1;
            }
        }
        // 边界条件:查找右侧区间,左边界到达坐标0点都没找到,返回-1
        if (left == 0) {
            return -1;
        }
        // 由于相等时,left = mid + 1,所以nums[left-1]才是=target的
        return nums[left - 1] == target ? left - 1 : -1;
    }

    // 右侧区间的二分查找:统一成标准二分查找的写法
    public static int rightBinarySearch2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 起始条件：0,n
        int left = 0, right = nums.length - 1;
        // 左侧区间的二分查找:[l,r)
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                // =时,查找右侧区间,left变大
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 3};
        System.out.println(leftBinarySearch(nums, 2));
        System.out.println(leftBinarySearch1(nums, 2));
        System.out.println(rightBinarySearch1(nums, 2));
        System.out.println(rightBinarySearch2(nums, 2));
    }


    /*
      二分查找-递归方式
     */
    public static <E extends Comparable<E>> int binarySearch1(E[] nums, E target) {
        int l = 0, r = nums.length - 1;
        return binarySearch1(nums, l, r, target);
    }

    private static <E extends Comparable<E>> int binarySearch1(E[] nums, int l, int r, E target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid].compareTo(target) == 0) {
            return mid;
        } else if (nums[mid].compareTo(target) > 0) {
            return binarySearch1(nums, l, mid - 1, target);
        } else {
            return binarySearch1(nums, mid + 1, r, target);
        }
    }

    /*
      二分查找-非递归方式
     */
    public static <E extends Comparable<E>> int binarySearch2(E[] nums, E target) {
        int l = 0, r = nums.length - 1;
        // nums[l,r]
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) == 0) {
                return mid;
            } else if (nums[mid].compareTo(target) > 0) {
                r = mid - 1;
            } else if (nums[mid].compareTo(target) < 0) {
                l = mid + 1;
            }
        }
        return -1;
    }

    /*
        二分查找变种：upper
        >target的最小值的索引
     */
    private static <E extends Comparable<E>> int upper(E[] nums, E target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) <= 0) {
                l = mid + 1;
            } else if (nums[mid].compareTo(target) > 0) {
                r = mid;
            }
        }
        return l;
    }

    /*
        二分查找变种：upper_ceil
        ==target，返回最大值索引；否则同upper
     */
    private static <E extends Comparable<E>> int upper_ceil(E[] nums, E target) {
        // upper返回>t的最小值索引
        int u = upper(nums, target);
        // 如果u-1存在且数组的值相同，就返回u-1=t的索引
        if (u - 1 >= 0 && nums[u - 1].compareTo(target) == 0) {
            return u - 1;
        }
        // 否则就返回u
        return u;
    }

    /*
      二分查找变种:upper_floor
      ==target，返回最小值索引；否则同upper 等价于 <=target的最大索引
   */
    private static <E extends Comparable<E>> int upper_floor(E[] nums, E target) {
        int l = -1, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            // nums[mid]==target时候，右边可能还有等于的情况，所以l=mid
            if (nums[mid].compareTo(target) <= 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /*
   二分查找变种：lower
      求<target的最大值索引
   */
    private static <E extends Comparable<E>> int lower(E[] nums, E target) {
        int l = -1, r = nums.length - 1;
        while (l < r) {
            // l和r相邻时候，由于移动得是l=mid，会出现死循环问题
            // 解决问题：r-l+1
            int mid = l + (r - l + 1) / 2;
            if (nums[mid].compareTo(target) < 0) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    /*
        二分查找变种：lower_ceil
        ==target，返回最大值索引；否则同lower 等价于>=target的最小值索引
    */
    private static <E extends Comparable<E>> int lower_ceil(E[] nums, E target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                // ==的时候，有可能是解，也有可能有相同的解在前面，所以归入到r中
                r = mid;
            }
        }
        return l;
    }

    /*
        二分查找变种:lower_floor
        lower_floor：==target，返回最小值索引；否则同lower
     */
    private static <E extends Comparable<E>> int lower_floor(E[] nums, E target) {
        int l = lower(nums, target);
        if (l + 1 < nums.length && nums[l + 1].compareTo(target) == 0) {
            return l + 1;
        }
        return l;
    }

    /*
        补充：使用>=target的方式实现二分查找
     */
    private static <E extends Comparable<E>> int search(E[] nums, E target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        // l是>=target的最小值索引
        if (l < nums.length && nums[l].compareTo(target) == 0) {
            return l;
        }
        return -1;
    }
}
