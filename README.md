# STOCK
1．建立一個STOCK data base
  
  Ａ.建立一個STOCK table
      CREATE TABLE `STOCK` (
        `STOCK_ID` int(11) NOT NULL,
        `STOCK_CODE` varchar(32) COLLATE utf8_bin NOT NULL,
        `STOCK_NAME` varchar(32) COLLATE utf8_bin NOT NULL
      ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
      
  B.建立一個StockDailyRecord  table
      CREATE TABLE `STOCK_DAILY_RECORD` (
      `DAILY_RECORD_ID` int(11) NOT NULL,
      `PRICE_OPEN` float NOT NULL,
      `PRICE_CLOSE` float NOT NULL,
      `PRICE_CHANGE` float NOT NULL,
      `VOLUME` int(11) NOT NULL,
      `DATE` date NOT NULL,
      `STOCK_ID` int(11) NOT NULL
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
      

C. 建立索引
    --
    -- 資料表索引 `STOCK`
    --
    ALTER TABLE `STOCK`
      ADD PRIMARY KEY (`STOCK_ID`);
      
  --
  -- 資料表索引 `STOCK_DAILY_RECORD`
  --
  ALTER TABLE `STOCK_DAILY_RECORD`
    ADD PRIMARY KEY (`DAILY_RECORD_ID`),
    ADD KEY `STOCK_ID` (`STOCK_ID`);

  --    
      
D. 加foreign key
ALTER TABLE `STOCK_DAILY_RECORD`
  ADD CONSTRAINT `stock_daily_record_ibfk_1` FOREIGN KEY (`STOCK_ID`) REFERENCES `STOCK` (`STOCK_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
      
      
      
