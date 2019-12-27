package com.kirb.dao;

import com.kirb.pojo.Chvmotor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("chvmotorMapper")
public interface ChvmotorMapper {
    /**
     * 添加
     * @param chvmotor
     * @return
     */
    public int addChvmotor(Chvmotor chvmotor);

    /**
     * 根据姓名模糊查询并进行分页
     * @param motername 按姓名模糊查询
     * @param currPage 当前页码
     * @param pageSize 每页条数
     * @return
     */
    public List<Chvmotor> findmoterName(
            @Param("motername") String motername,
            @Param("currPage") int currPage,
            @Param("pageSize") int pageSize);

    /**
     * 查询记录总条数
     * @param
     * @return
     */
    public int findmoterNameCount(
            @Param("motername") String motername);

    /**
     * 根据ID删除数据
     * @param id
     * @return
     */
    public int delChvmotorById(
            @Param("id") int id);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public Chvmotor findChvmotorById(@Param("id") int id);

    /**
     * 修改数据
     * @param chvmotor
     * @return
     */
    public int updChvmotor(Chvmotor chvmotor);

    List<Chvmotor> getInfoByName(Map map);
}
