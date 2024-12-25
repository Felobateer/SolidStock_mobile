import React from "react";
import { View, StyleSheet } from "react-native";
import { LinearGradient } from "expo-linear-gradient"; // Use expo-linear-gradient

const GradientLine = () => {
  return (
    <View style={styles.container}>
      <LinearGradient
        colors={["transparent", "#808080", "transparent"]} // Grey in the center, transparent on sides
        start={{ x: 0, y: 0 }} // Start gradient from the left
        end={{ x: 1, y: 0 }} // End gradient to the right
        style={styles.gradientLine}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    height: 30,
    justifyContent: "center",
    alignItems: "center",
  },
  gradientLine: {
    width: 250, // Adjust the width of the line
    height: 2, // Line thickness
    borderRadius: 1,
  },
});

export default GradientLine;
