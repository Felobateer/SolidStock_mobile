import { View, Text, TextInput, TouchableOpacity } from "react-native";
import React from "react";
import styles from "@/components/styles";

const Signup = () => {
  return (
    <View className="my-auto flex flex-col justify-center items-center">
      <Text className={styles.title}>Register</Text>
      <View className="flex flex-col justify-start items-start my-4">
        <View className={styles.inputContainer}>
          <Text className={styles.text}>Name</Text>
          <TextInput className={styles.form} placeholder="Joe Smith" />
        </View>
        <View className={styles.inputContainer}>
          <Text className={styles.text}>Email</Text>
          <TextInput
            className={styles.form}
            placeholder="example@solidstock.com"
          />
        </View>
        <View className={styles.inputContainer}>
          <Text className={styles.text}>Phone</Text>
          <TextInput className={styles.form} placeholder="+4999999999999" />
        </View>
        <View className={styles.inputContainer}>
          <Text className={styles.text}>Date of Birth</Text>
          <TextInput className={styles.form} placeholder="01.01.2025" />
        </View>
        <View className={styles.inputContainer}>
          <Text className={styles.text}>Password</Text>
          <TextInput className={styles.form} placeholder="**********" />
        </View>
      </View>
      <TouchableOpacity className={styles.submit}>
        <Text className={styles.btnTextBlack}>Sign up</Text>
      </TouchableOpacity>
    </View>
  );
};

export default Signup;
