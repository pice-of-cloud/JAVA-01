####1. 拆分业务，用户中心和订单中心、商品三个库；仅对订单表分表
####2. 一主库，2个从库，分两A组，B组；连个分租本机只用两个数据库代替，没做单独的数据库实例
####3. 每组订单根据用户id分表，16张表。