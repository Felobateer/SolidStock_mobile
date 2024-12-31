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

export interface Stock {
  img: string;
  name: string;
  sym: string;
  price: number;
}

export default function HomeScreen() {
  const stocks: Stock[] = [
    {
      img: "	https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AAPL.png",
      name: "Apple Inc",
      sym: "AAPL",
      price: 252.2,
    },
    {
      img: "	https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/GOOG.png",
      name: "Alphabet Inc",
      sym: "GOOG",
      price: 191.24,
    },
    {
      img: "https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/MSFT.png",
      name: "Microsoft Corp",
      sym: "MSFT",
      price: 424.83,
    },
    {
      img: "	https://static2.finnhub.io/file/publicdatany/finnhubimage/stock_logo/AMZN.png",
      name: "Amazon.com Inc",
      sym: "AMZN",
      price: 221.3,
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
  ];

  return (
    <ParallaxScrollView
      headerBackgroundColor={{ light: "#1f2937", dark: "#1D3D47" }}
      headerImage={
        <View className={nativeStyle.layoutStyles.center + "my-5 py-10 gap-6"}>
          <View className={nativeStyle.layoutStyles.row}>
            <View className={nativeStyle.layoutStyles.card + "flex-1 mr-20"}>
              <Text className={nativeStyle.textStyles.heading}>
                Hi, Welcome Back
              </Text>
              <Text className={nativeStyle.textStyles.subHeading}>
                Good Morning
              </Text>
            </View>
            <TouchableOpacity className={nativeStyle.buttonStyles.disabled}>
              {/* <Image
                className={nativeStyle.imageStyles.avatar}
                source={require("@/assets/images/solidstockheader.PNG")}
              /> */}
              <Text className={nativeStyle.textStyles.caption}>logo</Text>
            </TouchableOpacity>
          </View>
          <View className={nativeStyle.layoutStyles.row}>
            <View className={nativeStyle.layoutStyles.column}>
              <Text className={nativeStyle.textStyles.body}>Total Balance</Text>
              <Text className={nativeStyle.textStyles.heading}>$4,763.00</Text>
            </View>
            <View className="w-1 h-[30px] border-l border-gray-300 shadow-lg shadow-gray-400 mx-10" />
            <View className={nativeStyle.layoutStyles.column}>
              <Text className={nativeStyle.textStyles.body}>Profits</Text>
              <Text className={nativeStyle.textStyles.heading}>+$723.00</Text>
            </View>
          </View>
          <View className={nativeStyle.layoutStyles.center + "flex gap-3"}>
            <Text className={nativeStyle.textStyles.overline}>
              The market is currently open
            </Text>
            <Text className={nativeStyle.textStyles.overline + "py-3"}>
              Your most profitable stock is AAPL
            </Text>
          </View>
        </View>
      }
    >
      <View className={nativeStyle.layoutStyles.center}>
        {stocks.map((stock: Stock) => {
          return (
            <View className={nativeStyle.layoutStyles.row} key={stock.sym}>
              <Image source={{ uri: stock.img }} />
              <Text className={nativeStyle.textStyles.body}>{stock.name}</Text>
              <Text className={nativeStyle.textStyles.body}>{stock.sym}</Text>
              <Text className={nativeStyle.textStyles.body}>{stock.price}</Text>
            </View>
          );
        })}
      </View>
    </ParallaxScrollView>
  );
}
