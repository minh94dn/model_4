package com.example.demo_bai_thi.repository;

import com.example.demo_bai_thi.dto.IDetailDto;
import com.example.demo_bai_thi.model.NguoiThue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface INguoiThueRepository extends JpaRepository<NguoiThue, Integer> {
    @Query(value = "select nguoi_thue.* from `nguoi_thue` join `hinh_thuc_hanh_toan` htht on htht.id = nguoi_thue.hinh_thuc_thanh_toan_id where nguoi_thue.name like %:name% and nguoi_thue.phone_number like %:phoneNumber% order by nguoi_thue.start_day", nativeQuery = true)
    Page<NguoiThue> findByNameAndPhoneNumber(@Param("name") String name, @Param("phoneNumber") String phoneNumber, Pageable pageable);

//    @Query(value = "delete from `nguoi_thue` where id in (%:deleteId%)",nativeQuery = true)
//    void deleteByCheckBox(@Param("deleteId") String deleteId);

    @Query(value = "select nguoi_thue.id, nguoi_thue.name, nguoi_thue.phone_number as phoneNumber, nguoi_thue.start_day as startDay, htht.name as hinhThucThanhToan from `nguoi_thue` join `hinh_thuc_hanh_toan` htht on htht.id = nguoi_thue.hinh_thuc_thanh_toan_id where nguoi_thue.id=:id", nativeQuery = true)
    List<IDetailDto> showDetail(@Param("id") int id);
}
