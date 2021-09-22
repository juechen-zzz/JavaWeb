package stream;

/**
 * @description: Stream流，测试实体类
 * @author: Komorebi
 * @time: 2021/8/31 16:43
 */
public class Category {
    private Long id;                        // 主键
    private String title;                   // 分类标题
    private String subTitle;                // 子标题
    private Long pid;                       // 父ID
    private Integer sort;                   // 排序

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Category() {
    }

    public Category(Long id, String title, String subTitle, Long pid, Integer sort) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.pid = pid;
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", pid=" + pid +
                ", sort=" + sort +
                '}';
    }
}
