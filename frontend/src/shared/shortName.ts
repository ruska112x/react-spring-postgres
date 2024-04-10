export const short_name = (name: string) => {
  if (name.split(" ").length > 2) {
    return name.split(" ")[0][0] + name.split(" ")[1][0];
  } else {
    return name.split(" ")[0][0];
  }
};
