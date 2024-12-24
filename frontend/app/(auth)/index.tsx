import { View, Text } from "react-native";
import React from "react";
import { ThemedView } from "@/components/ThemedView";
import { ThemedText } from "@/components/ThemedText";
import ThemedInput from "@/components/ThemedInput";
import ThemedButton from "@/components/ThemedButton";

const LoginScreen = () => {
  return (
    <View>
      <ThemedView>
        <ThemedText type="title">Login</ThemedText>
      </ThemedView>
      <ThemedView>
        <ThemedInput>
          <ThemedInput
            label="Username"
            hint="example@solidstock.com"
          ></ThemedInput>
        </ThemedInput>
        <ThemedInput label="Password" hint="**********"></ThemedInput>
        <ThemedButton backgroundColor="#000" text="Login"></ThemedButton>
      </ThemedView>
    </View>
  );
};

export default LoginScreen;
