import React from 'react';
import { EmployeeComponent } from '../../../components/pages/employee/employee.component';
import { shallow } from 'enzyme';

describe('employee.component.tsx', () => {
  test('should render', () => {
    const wrapper = shallow(<EmployeeComponent />);
    expect(wrapper).toBeDefined();
  });
});