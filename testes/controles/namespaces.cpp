#include <iostream>

namespace name1
{
    int num = 0;
} // namespace name1

namespace name2
{
    int num = 1;
} // namespace name2

using namespace name1;
using namespace name2;

int main(int argc, char const *argv[])
{
    //std::cout << "Numero 1: " << num << std::endl;
    std::cout << "Numero 2: " << name1::num << std::endl;

    return 0;
}
