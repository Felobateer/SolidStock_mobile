import { View, Text, Image } from "react-native";
import React from "react";
import nativeStyle from "../styles";

export interface Stock {
  img: string;
  name: string;
  sym: string;
  price: number;
}

const PortfolioScreen = () => {
  const stocks: Stock[] = [
    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/MSFT.png",
      name: "Microsoft Corp",
      sym: "MSFT",
      price: 424.83,
    },

    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/TSLA.png",
      name: "Tesla Inc",
      sym: "TSLA",
      price: 417.41,
    },
    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/NVDA.png",
      name: "NVIDIA Corp",
      sym: "NVDA",
      price: 137.49,
    },
    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/JPM.png",
      name: "JPMorgan Chase & Co",
      sym: "JPM",
      price: 239.32,
    },
    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/V.png",
      name: "Visa Inc",
      sym: "V",
      price: 315.31,
    },
    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/WMT.png",
      name: "Walmart Inc",
      sym: "WMT",
      price: 90.57,
    },
    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/JNJ.png",
      name: "Johnson & Johnson",
      sym: "JNJ",
      price: 143.34,
    },
    {
      img: "	https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.png",
      name: "Apple Inc",
      sym: "AAPL",
      price: 252.2,
    },
    {
      img: "	https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AMZN.png",
      name: "Amazon.com Inc",
      sym: "AMZN",
      price: 221.3,
    },
    {
      img: "	https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/GOOG.png",
      name: "Alphabet Inc",
      sym: "GOOG",
      price: 191.24,
    },
  ];

  return (
    <View className="bg-gray-800">
      <View className="rounded-xl bg-gradient-to-r from-black to-gray-400 p-4 flex flex-col gap-2 items-center">
        <Image source={require("@/assets/images/solidstockLogo.png")} />
        <Image
          source={require("@/assets/images/graph.jpg")}
          className="w-[250px] h-[150px] rounded-lg"
        />
      </View>
      <View className="flex flex-col gap-2 px-4">
        {stocks.map((stock: Stock) => (
          <View
            className="flex flex-row items-center justify-between bg-transparent py-2 border-b border-gray-300"
            key={stock.sym}
          >
            {/* Stock Image */}
            <Image
              source={{ uri: stock.img }}
              className="w-[50px] h-[50px] rounded-full"
            />

            {/* Stock Name */}
            <View className="flex-1 px-2">
              <Text
                className={`${nativeStyle.textStyles.body} text-center`}
                numberOfLines={2}
                ellipsizeMode="tail"
              >
                {stock.name}
              </Text>
            </View>

            {/* Stock Symbol */}
            <View className="flex items-center justify-center border-l border-r border-gray-300 px-4">
              <Text className={nativeStyle.textStyles.body}>{stock.sym}</Text>
            </View>

            {/* Stock Price */}
            <Text
              className={`${nativeStyle.textStyles.body} text-right w-[80px]`}
            >
              {stock.price}
            </Text>
          </View>
        ))}
      </View>
    </View>
  );
};

export default PortfolioScreen;
