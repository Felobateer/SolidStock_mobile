import { View, Text, StyleSheet } from "react-native";
import React from "react";
import { ThemedView } from "@/components/ThemedView";
import { ThemedText } from "@/components/ThemedText";
import ThemedInput from "@/components/ThemedInput";
import ThemedButton from "@/components/ThemedButton";

const LoginScreen = () => {
  return (
    <View className=" flex-1 p-10">
      <ThemedView>
        <ThemedText type="title">Login</ThemedText>
      </ThemedView>
      <ThemedView>
        <ThemedInput
          label="Username"
          hint="example@solidstock.com"
        ></ThemedInput>
        <ThemedInput label="Password" hint="**********"></ThemedInput>
        <ThemedButton backgroundColor="#000" text="Login"></ThemedButton>
      </ThemedView>
    </View>
  );
};

export default LoginScreen;
