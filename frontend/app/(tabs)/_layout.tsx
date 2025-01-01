import { Tabs } from "expo-router";
import React from "react";
import { Platform } from "react-native";

import { HapticTab } from "@/components/HapticTab";
import { IconSymbol } from "@/components/ui/IconSymbol";
import TabBarBackground from "@/components/ui/TabBarBackground";
import { Colors } from "@/constants/Colors";
import { useColorScheme } from "@/hooks/useColorScheme";

export default function TabLayout() {
  const colorScheme = useColorScheme();
  const tabBarTintColor = "#1f2937";

  return (
    <Tabs
      screenOptions={{
        tabBarActiveTintColor: "#d1d5db", // Active tab color
        tabBarInactiveTintColor: "#7c7c7c", // Inactive tab color (optional)
        headerShown: false,
        tabBarButton: HapticTab, // Custom button (ensure HapticTab is defined)
        tabBarStyle: {
          backgroundColor: tabBarTintColor, // Tab bar background color
          borderTopWidth: 0, // Optional: Remove border on top of the tab bar
          ...Platform.select({
            ios: {
              position: "absolute",
              bottom: 0,
              left: 0,
              right: 0,
              height: 70, // Total height (tab bar + padding)
              paddingBottom: 10, // Additional padding on iOS
            },
            default: {
              height: 60, // Default height for other platforms
            },
          }),
        },
      }}
    >
      <Tabs.Screen
        name="index"
        options={{
          title: "Home",
          tabBarIcon: ({ color }) => (
            <IconSymbol size={28} name="house.fill" color={"#cbb26a"} />
          ),
        }}
      />
      <Tabs.Screen
        name="explore"
        options={{
          title: "Market",
          tabBarIcon: ({ color }) => (
            <IconSymbol size={28} name="chart.fill" color={"#cbb26a"} />
          ),
        }}
      />
      <Tabs.Screen
        name="portfolio"
        options={{
          title: "Portfolio",
          tabBarIcon: ({ color }) => (
            <IconSymbol size={28} name="case.fill" color={"#cbb26a"} />
          ),
        }}
      />
      <Tabs.Screen
        name="account"
        options={{
          title: "Account",
          tabBarIcon: ({ color }) => (
            <IconSymbol size={28} name="user.fill" color={"#cbb26a"} />
          ),
        }}
      />
    </Tabs>
  );
}
