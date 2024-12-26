import { Image, StyleSheet, View, Text, Platform } from "react-native";
import { Link } from "expo-router";
import React from "react";
import ParallaxScrollView from "react-native-parallax-scroll-view";

export default function HomeScreen() {
  return (
    <ParallaxScrollView
      backgroundColor="blue"
      contentBackgroundColor="pink"
      parallaxHeaderHeight={300}
      renderForeground={() => (
        <View>
          <Text>Hello World!</Text>
        </View>
      )}
    >
      <View>
        <Text>John_Doe</Text>
      </View>
    </ParallaxScrollView>
  );
}
