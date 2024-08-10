export default function GrowMoneyImage({
  width,
  height
}: {
  width?: number,
  height?: number
}) {
  return (
    <img src={"assets/icons/grow-money-plant-230.png"} srcSet="
      assets/icons/grow-money-plant-230.png 400w,
      assets/icons/grow-money-plant.png 800w"
      alt="Plant growth money"
      sizes="(max-width: 600px) 230px, 300px"
      width={width}
    />
  )
}