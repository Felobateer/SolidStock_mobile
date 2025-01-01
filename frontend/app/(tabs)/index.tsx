import {
  Image,
  StyleSheet,
  Platform,
  View,
  Text,
  TouchableOpacity,
} from "react-native";
import nativeStyle from "../styles";
import ParallaxScrollView from "@/components/ParallaxScrollView";
import { IconSymbol } from "@/components/ui/IconSymbol";

export interface Stock {
  img: string;
  name: string;
  sym: string;
  price: number;
}

export default function HomeScreen() {
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
    <ParallaxScrollView
      headerBackgroundColor={{ light: "#1f2937", dark: "#1D3D47" }}
      headerImage={
        <View className={`${nativeStyle.layoutStyles.center} my-2 py-8 gap-6`}>
          <View className={`${nativeStyle.layoutStyles.row} gap-4`}>
            <View className={`${nativeStyle.layoutStyles.card} flex-1`}>
              <Text className={nativeStyle.textStyles.heading}>
                Hi, Welcome Back
              </Text>
              <Text className={nativeStyle.textStyles.subHeading}>
                Good Morning
              </Text>
            </View>
            <TouchableOpacity
              className={nativeStyle.buttonStyles.disabled + " bg-slate-600"}
            >
              <IconSymbol name="bell.fill" color={"#cbb26a"} />
            </TouchableOpacity>
          </View>

          <View className={`${nativeStyle.layoutStyles.row} gap-10`}>
            <View className={nativeStyle.layoutStyles.column}>
              <Text className={nativeStyle.textStyles.body}>Total Balance</Text>
              <Text className={nativeStyle.textStyles.heading}>$4,763.00</Text>
            </View>
            <View className="w-1 h-[30px] border-l border-gray-300 shadow-lg shadow-gray-400" />
            <View className={nativeStyle.layoutStyles.column}>
              <Text className={nativeStyle.textStyles.body}>Profits</Text>
              <Text className={nativeStyle.textStyles.heading}>+$723.00</Text>
            </View>
          </View>

          <View className={`${nativeStyle.layoutStyles.center} flex gap-3`}>
            <Text className={nativeStyle.textStyles.overline}>
              The market is currently open
            </Text>
            <Text className={`${nativeStyle.textStyles.overline} py-3`}>
              Your most profitable stock is AAPL
            </Text>
          </View>
        </View>
      }
    >
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
    </ParallaxScrollView>
  );
}
