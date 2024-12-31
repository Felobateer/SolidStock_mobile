// Define font families
const poppins = "Poppins";
const roboto = "Roboto";

// Text styles
export const textStyles = {
  heading: "text-2xl font-bold text-gray-900 font-[Poppins]",
  subHeading: "text-xl font-semibold text-gray-700 font-[Roboto]",
  body: "text-base text-gray-600 font-[Roboto]",
  caption: "text-sm text-gray-500 font-[Roboto]",
  overline: "text-xs uppercase tracking-widest text-gray-400 font-[Roboto]",
};

// Button styles
export const buttonStyles = {
  primary:
    "bg-blue-500 px-4 py-2 rounded-lg text-white text-center font-[Poppins] shadow-md",
  secondary:
    "bg-gray-200 px-4 py-2 rounded-lg text-gray-700 text-center font-[Poppins]",
  outline:
    "border-2 border-blue-500 px-4 py-2 rounded-lg text-blue-500 text-center font-[Poppins]",
  disabled:
    "bg-gray-300 px-4 py-2 rounded-lg text-gray-500 text-center font-[Poppins]",
  text: "text-blue-500 text-center font-[Poppins] underline",
};

// Input styles
export const inputStyles = {
  base: "border border-gray-300 rounded-lg px-4 py-2 text-base text-gray-800 font-[Roboto] focus:border-blue-500 focus:ring-2 focus:ring-blue-300",
  error:
    "border border-red-500 rounded-lg px-4 py-2 text-base text-red-600 font-[Roboto] focus:border-red-500 focus:ring-2 focus:ring-red-300",
  disabled:
    "border border-gray-200 bg-gray-100 rounded-lg px-4 py-2 text-base text-gray-500 font-[Roboto]",
};

// Icon styles
export const iconStyles = {
  small: "w-4 h-4 text-gray-600",
  medium: "w-6 h-6 text-gray-800",
  large: "w-8 h-8 text-gray-900",
  primary: "text-blue-500",
  secondary: "text-gray-500",
};

// Image styles
export const imageStyles = {
  small: "w-16 h-16 rounded-md",
  medium: "w-32 h-32 rounded-md",
  large: "w-64 h-64 rounded-md",
  fullWidth: "w-full h-auto",
  avatar: "w-10 h-10 rounded-full",
};

// Common layout styles
export const layoutStyles = {
  row: "flex-row items-center justify-between",
  column: "flex-col items-start",
  center: "flex items-center justify-center",
  spaceBetween: "flex justify-between",
  spaceAround: "flex justify-around",
  card: "bg-white shadow-md rounded-lg p-4",
  container: "px-4 py-6",
};

export default {
  textStyles,
  buttonStyles,
  inputStyles,
  iconStyles,
  imageStyles,
  layoutStyles,
};
