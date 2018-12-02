package com.pershyn.electronicshop.model;

public enum Status {

    // заказ ожидает обработки администратором или модератором
    WAIT,
    // заказ в процессе доставки
    IN_PROCESS,
    // заказ успешно выполнен
    DONE;
//    private final String status;
//
//    Status(String status) {
//        this.status = status;
//    }
//    public String getStatus(){
//        return status;
//    }

}
