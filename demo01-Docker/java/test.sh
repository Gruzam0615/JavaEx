echo "Springboot Demo01을 실행합니다."

FileName="demo01-0.0.1.jar"

if [ -f"$FileName" ] ; then
    echo "$FileName 을 실행합니다."
    java -jar $FileName
else
    echo "$FileName 이 존재하지 않습니다."
fi