import { Tabs } from "expo-router";
import React from "react";
import { Platform } from "react-native";
import { FontAwesome } from "@expo/vector-icons";
import { HapticTab } from "@/components/HapticTab";
import TabBarBackground from "@/components/ui/TabBarBackground";
import { Colors } from "@/constants/Colors";
import { useColorScheme } from "@/hooks/useColorScheme";

export default function TabLayout() {
  const colorScheme = useColorScheme();

  return (
    <Tabs
      screenOptions={{
        tabBarActiveTintColor: Colors[colorScheme ?? "light"].tint,
        headerShown: false,
        tabBarButton: HapticTab,
        tabBarBackground: TabBarBackground,
        tabBarStyle: Platform.select({
          ios: {
            position: "absolute",
            height: 60, // Height of the tab bar
            paddingBottom: 10, // Padding for iOS devices
            backgroundColor: Colors[colorScheme ?? "light"].background, // Background color
          },
          default: {
            height: 48, // Default height for non-iOS platforms
            backgroundColor: Colors[colorScheme ?? "light"].background, // Background color
          },
        }),
      }}
    >
      <Tabs.Screen
        name="index"
        options={{
          title: "Home",
          tabBarIcon: ({ color, size }) => (
            <FontAwesome
              name="home"
              size={size || 80}
              color={color || "#900"}
            />
          ),
        }}
      />
      {/* Stock Market Tab */}
      <Tabs.Screen
        name="market"
        options={{
          title: "Market",
          tabBarIcon: ({ color, size }) => (
            <FontAwesome
              name="line-chart"
              size={size || 24}
              color={color || "#900"}
            />
          ),
        }}
      />
      {/* Portfolio Tab */}
      <Tabs.Screen
        name="portfolio"
        options={{
          title: "Portfolio",
          tabBarIcon: ({ color, size }) => (
            <FontAwesome
              name="pie-chart"
              size={size || 24}
              color={color || "#900"}
            />
          ),
        }}
      />
      {/* Account Tab */}
      <Tabs.Screen
        name="account"
        options={{
          title: "Account",
          tabBarIcon: ({ color, size }) => (
            <FontAwesome
              name="user"
              size={size || 24}
              color={color || "#900"}
            />
          ),
        }}
      />
    </Tabs>
  );
}
