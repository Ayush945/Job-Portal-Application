/**
 * Ayush Thapa
 * Navbar Component
 */
import { Box, Button, Flex, Heading, Spacer, Text } from '@chakra-ui/react';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';

function Navbar() {
  const [setProfileStatus, IsSetProfileStatus] = useState(false)


  return (
    <Box
      as="nav"
      bg="#BED9F8"
      py={4}
      px={8}
      display="flex"
      alignItems="center"
      justifyContent="space-between"
      className='navbar'
    >
      <Heading fontSize="xl" className=' hover:cursor-pointer'>Job Portal</Heading>
      <Flex gap={4} className='justify-between w-full md:w-auto'>
        <Link to={'/'} className=' hover:text-white cursor-pointer'>Home</Link>
        <Link to={'/find-companies'} className=' hover:text-white'>Company Review</Link>
        <Link to={'/find-salaries'} className=' hover:text-white'>Salaries</Link>
      </Flex>
      <Flex gap={4}>
        <Button variant="ghost" as={Link} to={'message'}>Message</Button>
        <Button variant="ghost" as={Link} to={'notification'}>Notification</Button>
        <Button
          variant="ghost"
          as={Link} to={setProfileStatus ? "/profile" : "/register-jobseeker"}
        >
          {setProfileStatus ? "Profile" : "Sign In"}</Button>
      </Flex>
      <Button variant="outline" borderWidth={3} as={Link} to={'/register-company'}>Post Job</Button>
      <style jsx>
        {`
          @media (max-width: 768px) {
            .navbar {
              flex-wrap: wrap;
              justify-content: space-between;
            }

            .navbar button {
              width: 100%;
            }
          }
        `}
      </style>
    </Box>
  );
}

export default Navbar;
