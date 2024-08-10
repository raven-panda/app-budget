export default function GreetingsImage({
  width,
  height
}: {
  width?: number,
  height?: number
}) {
  return (
    <img src={"assets/icons/greetings-300.png"} srcSet="
      assets/icons/greetings-300.png 400w,
      assets/icons/greetings-300.png 800w"
      alt="Man saluting"
      sizes="(max-width: 600px) 230px, 300px"
      width={width}
    />
  )
}